#!/usr/bin/env python3
import asyncore, socket
import sys
import threading
import logging

logger = logging.getLogger('lsp-daemon')
hdlr = logging.FileHandler('/Users/ppinheiro/git_tree/pinelang/lsp/server/lsp-daemon.log')
formatter = logging.Formatter('%(asctime)s %(levelname)s %(message)s')
hdlr.setFormatter(formatter)
logger.addHandler(hdlr) 
logger.setLevel(logging.DEBUG)

PORT = 20001
HOST = 'localhost'

# This script is just a simple relay from stdin/stdout int the LSP server
# that resides on a Android App of whatever listen to LSP on a socket.

class TCPRelay(asyncore.dispatcher):

    def __init__(self, host, port):
        self.host = host
        self.port = port
        self.buffer = b''
        asyncore.dispatcher.__init__(self)
        self.create_socket(socket.AF_INET, socket.SOCK_STREAM)
        self.connect( (host, port) )
        self._thread = None

    def start(self):
        if self._thread is not None:
            return

        self._thread = threading.Thread(target=asyncore.loop, kwargs={'timeout':1})
        self._thread.daemon = True
        self._thread.start()

    def stop(self):
        self.close()
        if self._thread is not None:
            thread, self._thread = self._thread, None
            thread.join()

    def initiate_connection_with_server(self):
        asyncore.dispatcher.__init__(self)
        self.create_socket(socket.AF_INET, socket.SOCK_STREAM)
        self.connect((self.host,self.port))

    def handle_connect(self):
        logger.info('Connected')
        self.socket.settimeout(0.5)
        pass

    def handle_close(self):
        self.close()
        self.initiate_connection_with_server()

    def handle_read(self):
        data = self.recv(8*1024)
        logger.info(f'\n\nWriting to stdout: {len(data)}\n\n')
        logger.info(f'\n\ndata: {data}')
        sys.stdout.write(data.decode('utf-8'))
        sys.stdout.flush()
        logger.info(f'\n\nWriting to stdout done')

    def writable(self):
        return len(self.buffer) > 0

    def readable(self):
        return True

    def handle_write(self):
        logger.info(f'Writing to socket: {self.buffer}')
        sent = self.send(self.buffer)
        self.buffer = self.buffer[sent:]


if __name__ == '__main__':
    client = TCPRelay(HOST, PORT)
    client.start()
    logger.info(f'Daemon started')
    while True:
        header = sys.stdin.readline()
        logger.info(f'Received header from stdin: {header}')
        empty  = sys.stdin.readline()
        logger.info(f'Received emptyline stdin: {empty}')
        count  = int(header.replace('Content-Length: ','').replace('\r', '').replace('\n', ''))
        logger.info(f'Reading {count} from stdin')
        client.buffer = (header + empty + sys.stdin.read(count)).encode('utf-8')
