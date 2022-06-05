package com.project217ui.Models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.nio.charset.StandardCharsets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.project217ui.Databsae.database_managment;

public class DoctorModel {

    static Connection c;
    static Statement s;
    static String query;
    static String output;
    static ResultSet result;
    
    private static DoctorModel instance;
    
    
    public static DoctorModel Instance()
    {
        if(instance==null)
            instance = new DoctorModel();
        return instance;
    }
    
    
    private DoctorModel()
    {

    }


    public boolean TestLogin(String o_UserName, String o_Password)
    {
        try
        {
            return getHash(o_UserName).equals(getHash("AAA"))&&getHash(o_UserName+o_Password+getHash(o_UserName)).equals(getHash("AAA"+"AAA"+getHash("AAA")));        
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public boolean login(String o_UserName, String o_Password)
    {
        database_managment d=new database_managment();
        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
            query="select * from users where username='"+o_UserName+"' and password='"+o_Password+"'";
            result=s.executeQuery(query);
            if (result.next()!=false) {
                return true;
            } else {
               return false;
            }
       
 
         } catch (Exception ex) {
             System.err.println ("Cannot connect to database server");
             System.err.println("Message = " + ex.getMessage());
             System.err.println("printTrace /n");
             ex.printStackTrace();
         }
         finally
            {
                if (c != null)
                {
                    try
                    {
                        System.out.println("\n***** Let terminate the Connection *****");
                        c.close ();					   
                        System.out.println ("\nDatabase connection terminated...");
                    }
                    catch (Exception ex)
                    {
                    System.err.println ("Error in connection termination!");
                    }
                }
            }
        return true;
    }

    
    public boolean AddPetToDB(PetModel pet)
    {
        return findPetInDB(pet)!=null;
    }


    public PetModel findPetInDB(String petID)
    {
        return null;
    }


    public PetModel findPetInDB(PetModel pet)
    {
        return null;
    }    


    public boolean removePetFromDB(String petID)
    {
        return removePetFromDB(findPetInDB(petID));
    }


    public boolean removePetFromDB(PetModel pet)
    {
        return findPetInDB(pet)==null;
    }


    public boolean updatePetInDB(PetModel pet)
    {
        return true;
    }


    public boolean addVisitToPet(PetModel pet, VisitModel visit)
    {
        pet.addVisit(visit);
        return pet.getLastVisit()==visit;
    }


    public boolean removeVisitFromPet(PetModel pet, VisitModel visit)
    {
        pet.removeVisit(visit);
        return pet.getVisitIndex(visit)==-1;
    }

    public boolean removeVisitFromPet(PetModel pet, int visitIndex)
    {
        VisitModel visit= pet.getVisit(visitIndex);
        pet.removeVisit(visitIndex);
        return pet.getVisit(visitIndex)!=visit;
    }


    private static String getHash(String toBeHashed)throws NoSuchAlgorithmException
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
}