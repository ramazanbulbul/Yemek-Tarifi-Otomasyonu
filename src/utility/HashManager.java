package utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashManager {
	public static String PasswordToMD5(String Password) {

		try {
			MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
			messageDigestNesnesi.update(Password.getBytes());
			byte messageDigestDizisi[] = messageDigestNesnesi.digest();
			StringBuffer sb32 = new StringBuffer();
			for (int i = 0; i < messageDigestDizisi.length; i++)
				sb32.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 32));
			return sb32.toString();
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return null;
	}
}
