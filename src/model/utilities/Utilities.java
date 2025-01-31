package model.utilities;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import global.Constants;

public class Utilities {
	public byte[] encrypt(String text) {
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			DESKeySpec kspec = new DESKeySpec(Constants.CIPHERKEY.getBytes());
			SecretKey ks = skf.generateSecret(kspec);
			
			Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, ks);
			byte[] encVal = c.doFinal(text.getBytes());
			byte[] iv = c.getIV();
			return encVal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
