package com.mgabbi.encryption.lib

import java.nio.ByteBuffer
import java.security.AlgorithmParameters
import java.security.SecureRandom
import java.util.Base64
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

class Encryption {

    val secretKey = "abcdef"

    fun encrypt(word: String): String? {
        val ivBytes: ByteArray
        val password = "Hello"
        /*you can give whatever you want for password. This is for testing purpose*/
        val random = SecureRandom()
        val bytes = ByteArray(20)
        random.nextBytes(bytes)
        // Derive the key
        val factory: SecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        val spec = PBEKeySpec(password.toCharArray(), bytes, 65556, 256)
        val secretKey: SecretKey = factory.generateSecret(spec)
        val secret = SecretKeySpec(secretKey.getEncoded(), "AES")
        //encrypting the word
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secret)
        val params: AlgorithmParameters = cipher.parameters
        ivBytes = params.getParameterSpec(IvParameterSpec::class.java).getIV()
        val encryptedTextBytes = cipher.doFinal(word.toByteArray(charset("UTF-8")))
        //prepend salt and vi
        val buffer = ByteArray(bytes.size + ivBytes.size + encryptedTextBytes.size)
        System.arraycopy(bytes, 0, buffer, 0, bytes.size)
        System.arraycopy(ivBytes, 0, buffer, bytes.size, ivBytes.size)
        System.arraycopy(encryptedTextBytes, 0, buffer, bytes.size + ivBytes.size, encryptedTextBytes.size)
        return Base64.getEncoder().encodeToString(buffer)
    }

    fun decrypt(encryptedText: String?): String? {
        val password = "Hello"
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        //strip off the salt and iv
        val buffer = ByteBuffer.wrap(Base64.getDecoder().decode(encryptedText))
        val saltBytes = ByteArray(20)
        buffer.get(saltBytes, 0, saltBytes.size)
        val ivBytes1 = ByteArray(cipher.blockSize)
        buffer.get(ivBytes1, 0, ivBytes1.size)
        val encryptedTextBytes = ByteArray(buffer.capacity() - saltBytes.size - ivBytes1.size)
        buffer.get(encryptedTextBytes)
        // Deriving the key
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        val spec = PBEKeySpec(password.toCharArray(), saltBytes, 65556, 256)
        val secretKey = factory.generateSecret(spec)
        val secret = SecretKeySpec(secretKey.encoded, "AES")
        cipher.init(Cipher.DECRYPT_MODE, secret, IvParameterSpec(ivBytes1))
        var decryptedTextBytes: ByteArray? = null
        try {
            decryptedTextBytes = cipher.doFinal(encryptedTextBytes)
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        }
        return String(decryptedTextBytes!!)
    }
}