package model;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import global.Constants;

public class Utilities {
	public byte[] stringToByte(String text) {
		return text.getBytes();
	}
}
