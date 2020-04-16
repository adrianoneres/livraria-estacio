package me.adrianoneres.command;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Properties;

public class CriptografiaCommand implements Command {

        public static void main(String args[]) throws Exception{
            String valor = "123456";
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(valor.getBytes(),0,valor.length());
            System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
        }

    @Override
    public Object executar(Properties properties) {
        return null;
    }
}
