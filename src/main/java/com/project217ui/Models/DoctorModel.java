package com.project217ui.Models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
public class DoctorModel {


    public DoctorModel()
    {

    }


    public DoctorModel(String o_UserName, String o_Password) throws NoSuchAlgorithmException
    {
        m_UserNameHash = getHash(o_UserName);
        m_PasswordHash = getHash(o_UserName+o_Password+m_UserNameHash);
    }


    public boolean Login(String o_UserName, String o_Password) throws NoSuchAlgorithmException
    {
        return getHash(o_UserName).equals(m_UserNameHash)&&getHash(o_UserName+o_Password+getHash(o_UserName)).equals(m_PasswordHash);        
    }


    private String getHash(String toBeHashed)throws NoSuchAlgorithmException
    {
        MessageDigest md5Hasher = MessageDigest.getInstance("MD5");
        md5Hasher.update(toBeHashed.getBytes());
        return bytesToHex(md5Hasher.digest()).toUpperCase();
    }
    
    
    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
    private static String bytesToHex(byte[] bytes) {
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }


    private String m_UserNameHash;
    private String m_PasswordHash;
}