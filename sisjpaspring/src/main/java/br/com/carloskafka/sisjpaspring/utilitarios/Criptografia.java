package br.com.carloskafka.sisjpaspring.utilitarios;

import java.security.MessageDigest;

public class Criptografia {
	public static String converterParaMD5(String texto) {
		String retorno = null;
		if (texto != null && !texto.isEmpty()) {
			MessageDigest digest = null;
			try {
				digest = java.security.MessageDigest.getInstance("MD5");
				digest.update(texto.getBytes());
				retorno = converterParaBytes(digest.digest());
			} catch (Exception e) {				
			}
		}
		return retorno;
	}
	
	private static String converterParaBytes(byte[] b) {
		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		String hex = "";
		int msb;
		int lsb = 0;
		int i;

		for (i = 0; i < b.length; i++) {
			msb = ((int) b[i] & 0x000000FF) / 16;
			lsb = ((int) b[i] & 0x000000FF) % 16;
			hex = hex + hexChars[msb] + hexChars[lsb];
		}
		return hex;
	}
}
