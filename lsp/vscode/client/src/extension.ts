/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */

import * as path from 'path';
import { workspace, ExtensionContext } from 'vscode';

import {
	LanguageClient,
	LanguageClientOptions,
	ServerOptions,
	TransportKind,
	SocketTransport,
	createServerSocketTransport,
	MessageTransports,
	CloseAction,
	Message,
	ErrorAction,
	ResponseError,
	InitializeError
} from 'vscode-languageclient';

let client: LanguageClient;

export function activate(context: ExtensionContext) {
	
	// The debug options for the server
	// --inspect=6009: runs the server in Node's Inspector mode so VS Code can attach to the server for debugging
	let debugOptions = { execArgv: ['--nolazy', '--inspect=6009'] };

	// If the extension is launched in debug mode then the debug server options are used
	// Otherwise the run options are used
	let [reader, writer] = createServerSocketTransport(20001)
	
	let serverOptionsBase: ServerOptions = () =>  {
		return Promise.resolve({
				reader: reader,
				writer: writer,
				detached: true
			})
	}

	let serverOptions: ServerOptions = {
		command: "/Users/ppinheiro/git_tree/pinelang/lsp/server/daemon.py"
	}

	// Options to control the language client
	let clientOptions: LanguageClientOptions = {
		// Register the server for plain text documents
		outputChannelName: 'Pine Language Server',
		documentSelector: [{ scheme: 'file', language: 'pine' }],
		synchronize: {
			// Notify the server about file changes to '.clientrc files contained in the workspace
			fileEvents: workspace.createFileSystemWatcher('**/.clientrc')
		},
		initializationFailedHandler: function handler(error: ResponseError<InitializeError> | Error | any): boolean {
			if (client) {
				window.setTimeout(window.alert, 2*1000, 'That was really slow!');
				client.info("PV error", error)
			}
			return true
		},
		errorHandler: {
			error: function(error: Error, message: Message, count: number): ErrorAction {
				if (client) {
					client.info("PV FAILED SERVER")				
				}
				return ErrorAction.Shutdown
			},
			/**
			 * The connection to the server got closed.
			 */
			closed: function(): CloseAction {
				if (client) {
					client.info("PV SERVER CLOSED")
				}
				return CloseAction.Restart
			}
		}
	};
	// Create the language client and start the client.
	client = new LanguageClient(
		'languageServerExample',
		'languageServerExample',
		serverOptionsBase,
		clientOptions
	);
	// Start the client. This will also launch the server
	client.start();
}

export function deactivate(): Thenable<void> | undefined {
	
	if (!client) {
		client.info("Deactivate")
		return undefined;
	}
	return client.stop();
}
