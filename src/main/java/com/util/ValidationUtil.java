package com.util;

public class ValidationUtil {

	public static boolean isEmpty(String data) {

		if (data == null || data.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isAlpha(String data) {
		String alphaReg = "[a-zA-Z]+";

		return data.matches(alphaReg);

	}

	public static boolean isEmail(String email) {
		// XXXX@XXXX.XXXX
		// "[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,6}";
		String emailReg = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z09]{2,6}";
		return email.matches(emailReg);
	}

	public static boolean checkLength(String password, int minLen) {
		return password.length() >= minLen;
	}
}
