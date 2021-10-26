package handleliste;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class PassordUtil {
	public static String genererTilfeldigsalt() {

		SecureRandom sr;
		byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
			sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(salt);
	}

	public static String hashMSalt(String passord, String salt) {
		if (passord == null || salt == null) {
			throw new IllegalArgumentException();
		}

		char[] passC = passord.toCharArray();
		byte[] saltB = DatatypeConverter.parseHexBinary(salt);
		byte[] hash = null;
		try {
			PBEKeySpec pks = new PBEKeySpec(passC, saltB, 1000, 256);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hash = skf.generateSecret(pks).getEncoded();
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(hash);
	}

	public static boolean validerPassord(String passord, String salt, String hash) {
		
		return hash.equals(hashMSalt(passord, salt));
	}

}
