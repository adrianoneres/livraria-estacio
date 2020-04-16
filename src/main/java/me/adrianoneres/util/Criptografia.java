package me.adrianoneres.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    public static String criptografar(String valor) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(valor.getBytes(),0, valor.length());

        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
