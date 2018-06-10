/**
 * 
 */
package com.bujair.util;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author Bujair
 *
 */
public class EncryptUtil {

	private byte[] key;
    private static final String ALGORITHM = "AES";
    public EncryptUtil(byte[] key)
    {
        this.key = key;
    }

    /**
     * Encrypts the given plain text
     *
     * @param plainText The plain text to encrypt
     */
    public byte[] encrypt(byte[] plainText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText);
    }

    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to decrypt
     */
    public byte[] decrypt(byte[] cipherText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(cipherText);
    }
    public static void main(String args) throws Exception {
		byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
		byte[] plainText = "Hello world!".getBytes(StandardCharsets.UTF_8);
		EncryptUtil advancedEncryptionStandard = new EncryptUtil(
		        encryptionKey);
		byte[] cipherText = advancedEncryptionStandard.encrypt(plainText);
		byte[] decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);

		System.out.println(new String(plainText));
		System.out.println(new String(cipherText));
		System.out.println(new String(decryptedCipherText));
	}

}
