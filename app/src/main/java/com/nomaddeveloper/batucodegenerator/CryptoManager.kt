package com.nomaddeveloper.batucodegenerator

import java.util.Base64
import kotlin.experimental.xor

private const val XOR_KEY = 0xAB

class CryptoManager {
    fun encryptProduct(productId: Int): String {
        val idBytes = productId.toString().toByteArray()
        val encryptedBytes = ByteArray(idBytes.size)
        for (i in idBytes.indices) {
            encryptedBytes[i] = (idBytes[i] xor XOR_KEY.toByte())
        }
        return Base64.getEncoder().encodeToString(encryptedBytes)
    }

    fun decryptProduct(encryptedProduct: String): String {
        val encryptedBytes = Base64.getDecoder().decode(encryptedProduct)
        val decryptedBytes = ByteArray(encryptedBytes.size)
        for (i in encryptedBytes.indices) {
            decryptedBytes[i] = (encryptedBytes[i] xor XOR_KEY.toByte())
        }
        return String(decryptedBytes)
    }
}