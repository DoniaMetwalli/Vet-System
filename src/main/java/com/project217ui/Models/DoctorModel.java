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
            System.out.println(getHash(o_UserName));
            System.out.println(getHash(o_UserName+o_Password+getHash(o_UserName)));
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
            query="select * from users where username='"+getHash(o_UserName)+"' and password='"+getHash(o_UserName+o_Password+getHash(o_UserName))+"'";
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

    public boolean signUp(String o_UserName, String o_Password)
    {
        try
        {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
            if(s.executeQuery("select * from users where username = '"+getHash(o_UserName)+"'").next()!=false)
                return false;
            query="INSERT INTO users VALUES('"+getHash(o_UserName)+"','"+getHash(o_UserName+o_Password+getHash(o_UserName))+"')";
            s.executeUpdate(query);
            System.out.println("Inserted");
            
        }
        catch (Exception e)
        {

        }
        return login(o_UserName, o_Password);
    }

    public boolean AddPetToDB(String petName,String ownerName,String phoneNum,String petID,String petBreed,float petAge,float weight, String visitReason,String diagnosis)
    {
        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
             
            query="INSERT INTO pet VALUES('"+petID+"','"+ownerName+"','"+phoneNum+"', '"+petName+"','"+petBreed+"',"+petAge+","+weight+", '"+visitReason+"','"+diagnosis+"')";
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




        return findPetInDB(petName,ownerName, phoneNum,petID, petBreed, petAge, weight,  visitReason, diagnosis) !=null;
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
               return new PetModel(result.getString(4),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getFloat(6),result.getFloat(7),result.getString(8), result.getString(9));
            } else {
               System.out.println("pet not found");
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
    


    public PetModel findPetInDB(String petName,String ownerName,String phoneNum,String petID,String petBreed,float petAge,float weight, String visitReason,String diagnosis)
    {

        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
 
             //query="update pet set owner_name='"+owner_name+"',owner_phone='"+owner_phone+"',petname='"+petname+"',pet_breed='"+pet_breed+"',pet_age="+pet_age+",pet_weight="+pet_weight+" where petid="+petid;                                          
             query="select * from pet where petid='"+petID + "'and owner_name='"+ownerName+"' and owner_phone='"+phoneNum+"' and pet_name='"+petName+"' and pet_breed='"+petBreed+"' and pet_age="+petAge+" and pet_weight="+weight +" and visit_reason='"+visitReason+"' and diagnosis='"+diagnosis+"'";
             System.out.println(query);
               result= s.executeQuery(query);
               if (result.next()!=false) {
                System.out.println("Pet found");
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
        return findPetInDB(pet.getPetName(),pet.getOwnerName(),pet.getOwnerPhone(),pet.getPetID(),pet.getBreed(),pet.getAge(),pet.getWeight(),pet.getIssue(),pet.getDiagnosis());
    }

    public boolean removePetFromDB(String petID)
    {
        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
            query="Delete from pet where petid="+petID;
            int result=s.executeUpdate(query);
            if (result==1) {
                System.out.println("Record deleted");
             }
             else {
                System.out.println("No record to delete");
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
        return removePetFromDB(findPetInDB(petID));
    }


    public boolean removePetFromDB(PetModel pet)
    {
        return findPetInDB(pet)==null;
    }


    public boolean updatePetInDB(PetModel pet)
    {
        try {
            c = d.conn();
            System.out.println("Connected to DB");
            s=c.createStatement();
            query="update pet set owner_name='"+pet.getOwnerName()+"',owner_phone='"+pet.getOwnerPhone()+"',pet_name='"+pet.getPetName()+"',pet_breed='"+pet.getBreed()+"',pet_age="+pet.getAge()+",pet_weight='"+pet.getWeight()+ "',visit_reason='"+pet.getIssue()+"',diagnosis='"+pet.getDiagnosis()+"' where petid="+pet.getPetID();
            s.executeUpdate(query);

         } 
         catch (Exception ex) {
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