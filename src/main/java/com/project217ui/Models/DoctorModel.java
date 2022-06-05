package com.project217ui.Models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.nio.charset.StandardCharsets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.project217ui.Databsae.database_managment;

public class DoctorModel {
    database_managment d=new database_managment(); //creating object of database_managment class
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

    
    public boolean AddPetToDB(String petName,String ownerName,String phoneNum,String petID,String petBreed,float petAge,float weight, String visitReason,String diagnosis)
    {
        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
             
            query="INSERT INTO pet VALUES('"+petName+"','"+ownerName+"','"+phoneNum+"', '"+petName+"','"+petBreed+"',"+petAge+","+weight+", '"+visitReason+"','"+diagnosis+"')";
            s.executeUpdate(query);
            System.out.println("Inserted");
 
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




        return findPetInDB(pet)!=null;
    }


    public PetModel findPetInDB(String petID)
    {
        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
            query="select * from pet where petid="+petID;
         
            result=s.executeQuery(query);
            if (result.next()!=false) {
               System.out.println("Pet found");
               result=s.executeQuery(query);
               return new PetModel(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getFloat(6),result.getFloat(7),result.getString(8), result.getString(9));
            } else {
               System.out.println("User not found");
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

            return null;

        }
    


    public PetModel findPetInDB(PetModel pet)
    {

        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
 
             //query="update pet set owner_name='"+owner_name+"',owner_phone='"+owner_phone+"',petname='"+petname+"',pet_breed='"+pet_breed+"',pet_age="+pet_age+",pet_weight="+pet_weight+" where petid="+petid;                                          
             query="select * from pet where petid='"+pet.getPetID() + "'and owner_name='"+pet.getOwnerName()+"' and owner_phone='"+pet.getOwnerPhone()+"' and pet_name='"+pet.getPetName()+"' and pet_breed='"+pet.getBreed()+"' and pet_age="+pet.getAge()+" and pet_weight="+pet.getWeight() +" and visit_reason='"+pet.getIssue()+"' and diagnosis='"+pet.getDiagnosis()+"'";
             System.out.println(query);
               result= s.executeQuery(query);
               if (result.next()!=false) {
                System.out.println("Pet found");
                result=s.executeQuery(query);
                return new PetModel(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getFloat(6),result.getFloat(7),result.getString(8), result.getString(9));
             } else {
                System.out.println("User not found");
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