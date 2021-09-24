package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
    public static String fromString(String str){
        byte[] bytes = str.getBytes();
        MessageDigest md;
        
        try{
            md = MessageDigest.getInstance("SHA-1");
        }catch(NoSuchAlgorithmException ex){
            System.out.println("Hash Error: " + ex.getMessage());
            return null;
        }
        byte[] hash = md.digest(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b:hash) {
            sb.append(Integer.toString(b + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
