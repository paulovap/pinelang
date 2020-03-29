package com.pinescript.util

import java.util.zip.CRC32

fun String.crc32(): Long {
    val bytes = this.toByteArray()
    val checksum = CRC32()
    checksum.update(bytes, 0, bytes.size)
    return checksum.value
}