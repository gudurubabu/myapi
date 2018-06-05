/**
 * 
 */
package com.bujair.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * @author Bujair
 *
 */
public class PasswordUtil {

	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;

	/**
	 * Hashing on Password and Salt key
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}

	/**
	 * Creating secure password 
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String generateSecurePassword(String password, String salt) {
		String returnValue = null;
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		returnValue = Base64.getEncoder().encodeToString(securePassword);
		return returnValue;
	}

	/**
	 * validation for matching both the passwords are matched.
	 * 
	 * @param providedPassword
	 * @param securedPassword
	 * @param salt
	 * @return
	 */
	public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
		boolean returnValue = false;
		// Generate New secure password with the same salt
		String newSecurePassword = generateSecurePassword(providedPassword, salt);
		// Check if two passwords are equal
		returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
		return returnValue;
	}
}
