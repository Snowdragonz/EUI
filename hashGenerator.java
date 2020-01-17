package sample;

import java.math.BigInteger;
import java.security.MessageDigest;

public class hashGenerator {

    // Method can be referenced from http://oliviertech.com/java/generate-SHA256--SHA512-hash-from-a-String/
    public static String getMD2(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD2");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%032x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    // Method can be referenced from http://oliviertech.com/java/generate-SHA256--SHA512-hash-from-a-String/
    public static String getMD5(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%032x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    // Method can be referenced from http://oliviertech.com/java/generate-SHA256--SHA512-hash-from-a-String/
    public static String getSHA1(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    // Method can be referenced from http://oliviertech.com/java/generate-SHA256--SHA512-hash-from-a-String/
    public static String getSHA256(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    // Method can be referenced from http://oliviertech.com/java/generate-SHA256--SHA512-hash-from-a-String/
    public static String getSHA384(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-384");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%096x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    // Method can be referenced from http://oliviertech.com/java/generate-SHA256--SHA512-hash-from-a-String/
    public static String getSHA512(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }
}
