package com.study.springbootboard.service

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class EncodingTest {}

fun main() {
    val testEncoding = "TESTTESTTESTTEST" // 16 bytes

    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding") // PKCS5Padding 추가로 블록 크기 맞춤
    val keySpec = SecretKeySpec("AES256Key-123456".toByteArray(), "AES") // 16 bytes
    val ivParamSpec = IvParameterSpec("TESTTESTTESTTEST".toByteArray()) // 16 bytes

    // Encrypt
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec)
    val encrypted = cipher.doFinal(testEncoding.toByteArray())

    println("Encrypted : $encrypted")

    // Decrypt
    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec)
    val decrypted = cipher.doFinal(encrypted)
    println("Decrypted: ${decrypted}")
}