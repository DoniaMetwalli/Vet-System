package com.project217ui.Models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.nio.charset.StandardCharsets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.project217ui.Database.database_managment;

public class DoctorModel {
    // Database connection
    static database_managment d = new database_managment(); // creating object of database_managment class
    static Connection c;
    static Statement s;
    static String query;
    static String output;
    static ResultSet result;
    // Create a static Doctor Instance for the Singleton
    private static DoctorModel instance;

    /**
     * 
     * @return Doctor Model Static Instance
     */
    public static DoctorModel Instance() {
        if (instance == null)
            instance = new DoctorModel();
        return instance;
    }

    /**
     * Make the default constructor unavailable to prevent object creation
     */
    private DoctorModel() {

    }

    /**
     * Checks if the o_UserName o_Password exists in the database
     * 
     * @param o_UserName
     * @param o_Password
     * @return True if combination is found in Database, Otherwise False
     */
    public boolean login(String o_UserName, String o_Password) {

        try {
            // Create a new Connection to the Database
            c = d.conn();
            System.out.println("Connected to DB");
            // Create a SQL query that gets all matches where the hash of the Username and
            // hash of the Salted password and executes it
            s = c.createStatement();
            query = "select * from users where username='" + getHash(o_UserName) + "' and password='"
                    + getHash(o_UserName + o_Password + getHash(o_UserName)) + "'";
            result = s.executeQuery(query);
            // Check if the query returned any results
            if (result.next() != false) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            // Logs exception if Connection to database failed
            System.err.println("Cannot connect to database server");
            System.err.println("Message = " + ex.getMessage());
            System.err.println("printTrace /n");
            ex.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    System.out.println("\n***** Let terminate the Connection *****");
                    c.close();
                    System.out.println("\nDatabase connection terminated...");
                } catch (Exception ex) {
                    System.err.println("Error in connection termination!");
                }
            }
        }
        return false;
    }

    /**
     * Adds a new Doctor to the Database with o_UserName o_Password as username and
     * password
     * 
     * @param o_UserName Username of the new doctor
     * @param o_Password Password of the new doctor
     * @return True if added successfully, False otherwise
     */
    public boolean signUp(String o_UserName, String o_Password) {
        try {
            // Create a new database connection
            c = d.conn();
            System.out.println("Connected to DB");
            // Create a first query that checks if another Doctor with the same username
            // exists
            // If that does exist, return false
            s = c.createStatement();
            if (s.executeQuery("select * from users where username = '" + getHash(o_UserName) + "'").next() != false)
                return false;
            // Create a SQL Statement to insert the hash of the username and the salted
            // password into the database
            query = "INSERT INTO users VALUES('" + getHash(o_UserName) + "','"
                    + getHash(o_UserName + o_Password + getHash(o_UserName)) + "')";
            s.executeUpdate(query);
            System.out.println("Inserted");

        } catch (Exception ex) {
            // Logs exception if Connection to database failed
            System.err.println("Cannot connect to database server");
            System.err.println("Message = " + ex.getMessage());
            System.err.println("printTrace /n");
            ex.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    System.out.println("\n***** Let terminate the Connection *****");
                    c.close();
                    System.out.println("\nDatabase connection terminated...");
                } catch (Exception ex) {
                    System.err.println("Error in connection termination!");
                }
            }
        }
        // Checks if the the Doctor was added successfully by attempting a log in
        return login(o_UserName, o_Password);
    }

    /**
     * Adds a new pet with a new ID to the database
     * 
     * @param petName     name of the new Pet
     * @param ownerName   Name of the owner of the new Pet
     * @param phoneNum    phone number of the owner of the new pet
     * @param petID       ID of the new Pet
     * @param petBreed    Breed of the new Pet
     * @param petAge      Age of the new Pet
     * @param weight      Weight of the new Pet
     * @param visitReason Reason for the visit of the new Pet
     * @param diagnosis   Diagnosis for the reason
     * @return True if added successfully, False otherwise.
     */
    public boolean AddPetToDB(String petName, String ownerName, String phoneNum, String petID, String petBreed,
            float petAge, float weight, String visitReason, String diagnosis) {
        try {
            // Creates a new Database connection
            c = d.conn();
            System.out.println("Connected to DB");
            // Creates a SQL Statement that inserts the pet Info into the database
            s = c.createStatement();
            query = "INSERT INTO pet VALUES('" + petID + "','" + ownerName + "','" + phoneNum + "', '" + petName + "','"
                    + petBreed + "'," + petAge + "," + weight + ", '" + visitReason + "','" + diagnosis + "')";
            s.executeUpdate(query);
            System.out.println("Inserted");

        } catch (Exception ex) {
            // Logs Error
            System.err.println("Cannot connect to database server");
            System.err.println("Message = " + ex.getMessage());
            System.err.println("printTrace /n");
            ex.printStackTrace();
        }

        finally {
            if (c != null) {
                try {
                    System.out.println("\n***** Let terminate the Connection *****");
                    c.close();
                    System.out.println("\nDatabase connection terminated...");
                } catch (Exception ex) {
                    System.err.println("Error in connection termination!");
                }
            }
        }
        // Checks if the newly added pet could be found in the database
        return findPetInDB(petName, ownerName, phoneNum, petID, petBreed, petAge, weight, visitReason,
                diagnosis) != null;
    }

    /**
     * Retrieves the first Record that has the @param petID
     * 
     * @param petID ID of the pet to be retrieved
     * @return the loaded pet model of the Pet with @param petID
     */
    public PetModel findPetInDB(String petID) {
        try {
            // Create Database Connection
            c = d.conn();
            System.out.println("Connected to DB");
            // Create a SQL query that get all pets with petID
            s = c.createStatement();
            query = "select * from pet where petid=" + petID;

            result = s.executeQuery(query);
            // Return the first pet found
            if (result.next() != false) {
                System.out.println("Pet found");
                return new PetModel(result.getString(4), result.getString(2), result.getString(3), result.getString(4),
                        result.getString(5), result.getFloat(6), result.getFloat(7), result.getString(8),
                        result.getString(9));
            } else {
                System.out.println("pet not found");
            }

        } catch (Exception ex) {
            // Logs Exceptions
            System.err.println("Cannot connect to database server");
            System.err.println("Message = " + ex.getMessage());
            System.err.println("printTrace /n");
            ex.printStackTrace();
        }

        finally {
            if (c != null) {
                try {
                    System.out.println("\n***** Let terminate the Connection *****");
                    c.close();
                    System.out.println("\nDatabase connection terminated...");
                } catch (Exception ex) {
                    System.err.println("Error in connection termination!");
                }
            }

        }

        return null;

    }

    /**
     * Searches for Exact Record of pet
     * 
     * @param petName     name of the Pet
     * @param ownerName   Name of the owner of the Pet
     * @param phoneNum    phone number of the owner of the pet
     * @param petID       ID of the Pet
     * @param petBreed    Breed of the Pet
     * @param petAge      Age of the Pet
     * @param weight      Weight of the Pet
     * @param visitReason Reason for the visit of the Pet
     * @param diagnosis   Diagnosis for the reason
     * @return A full pet model of the data if found, null otherwise
     */
    public PetModel findPetInDB(String petName, String ownerName, String phoneNum, String petID, String petBreed,
            float petAge, float weight, String visitReason, String diagnosis) {

        try {
            // Create database Connection
            c = d.conn();
            System.out.println("Connected to DB");
            // Create SQL Query that finds the exact pet model
            s = c.createStatement();
            query = "select * from pet where petid='" + petID + "'and owner_name='" + ownerName + "' and owner_phone='"
                    + phoneNum + "' and pet_name='" + petName + "' and pet_breed='" + petBreed + "' and pet_age="
                    + petAge + " and pet_weight=" + weight + " and visit_reason='" + visitReason + "' and diagnosis='"
                    + diagnosis + "'";
            System.out.println(query);
            result = s.executeQuery(query);
            // Returns the first Result found
            if (result.next() != false) {
                System.out.println("Pet found");
                return new PetModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
                        result.getString(5), result.getFloat(6), result.getFloat(7), result.getString(8),
                        result.getString(9));
            } else {
                System.out.println("User not found");
            }

        } catch (Exception ex) {
            // Logs Database errors
            System.err.println("Cannot connect to database server");
            System.err.println("Message = " + ex.getMessage());
            System.err.println("printTrace /n");
            ex.printStackTrace();
        }

        finally {
            if (c != null) {
                try {
                    System.out.println("\n***** Let terminate the Connection *****");
                    c.close();
                    System.out.println("\nDatabase connection terminated...");
                } catch (Exception ex) {
                    System.err.println("Error in connection termination!");
                }
            }
        }
        return null;
    }

    /**
     * Finds the exact PetModel in database
     * 
     * @param pet the petModel to be lookeedFor
     * @return the retrieved pet model, null if not found
     */
    public PetModel findPetInDB(PetModel pet) {
        return findPetInDB(pet.getPetName(), pet.getOwnerName(), pet.getOwnerPhone(), pet.getPetID(), pet.getBreed(),
                pet.getAge(), pet.getWeight(), pet.getIssue(), pet.getDiagnosis());
    }

    /**
     * Removes the first pet with petID found in the Database
     * 
     * @param petID ID of the pet to be removed
     * @return if the pet was correctly removed
     */
    public boolean removePetFromDB(String petID) {
        try {
            // Create Datbase connection
            c = d.conn();
            System.out.println("Connected to DB");
            // Create SQL Statement to delete the first Pet found
            s = c.createStatement();
            query = "Delete from pet where petid=" + petID;
            int result = s.executeUpdate(query);
            if (result == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            // Logs Database Errors
            System.err.println("Cannot connect to database server");
            System.err.println("Message = " + ex.getMessage());
            System.err.println("printTrace /n");
            ex.printStackTrace();
        }

        finally {
            if (c != null) {
                try {
                    System.out.println("\n***** Let terminate the Connection *****");
                    c.close();
                    System.out.println("\nDatabase connection terminated...");
                } catch (Exception ex) {
                    System.err.println("Error in connection termination!");
                }
            }
        }
        return false;
    }

    /**
     * Updates the first Record with the ID of pet
     * 
     * @param pet PetModel that contains the updated data
     * @return True if the Pet was updated successfully
     */
    public boolean updatePetInDB(PetModel pet) {
        try {
            // Create database connection
            c = d.conn();
            System.out.println("Connected to DB");
            // Create SQL Query that updates the pet where the ID is equal to the PetModel
            // ID
            s = c.createStatement();
            query = "update pet set owner_name='" + pet.getOwnerName() + "',owner_phone='" + pet.getOwnerPhone()
                    + "',pet_name='" + pet.getPetName() + "',pet_breed='" + pet.getBreed() + "',pet_age=" + pet.getAge()
                    + ",pet_weight='" + pet.getWeight() + "',visit_reason='" + pet.getIssue() + "',diagnosis='"
                    + pet.getDiagnosis() + "' where petid=" + pet.getPetID();
            s.executeUpdate(query);

        } catch (Exception ex) {
            // Logs Database errors
            System.err.println("Cannot connect to database server");
            System.err.println("Message = " + ex.getMessage());
            System.err.println("printTrace /n");
            ex.printStackTrace();
        }

        finally {
            if (c != null) {
                try {
                    System.out.println("\n***** Let terminate the Connection *****");
                    c.close();
                    System.out.println("\nDatabase connection terminated...");
                } catch (Exception ex) {
                    System.err.println("Error in connection termination!");
                }
            }
        }
        return findPetInDB(pet) != null;
    }

    /**
     * Gets the hashed string
     * 
     * @param toBeHashed original string
     * @return hashed string using md5
     * @throws NoSuchAlgorithmException Doesn't get thrown since Hashing algorithm
     *                                  doesn't get changed
     */
    private static String getHash(String toBeHashed) throws NoSuchAlgorithmException {
        MessageDigest md5Hasher = MessageDigest.getInstance("MD5");
        md5Hasher.update(toBeHashed.getBytes());
        return bytesToHex(md5Hasher.digest()).toUpperCase();
    }

    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);

    /**
     * takes Byte value and returns Hex String of the value
     * 
     * @param bytes Byte value
     * @return Hex Representation of bytes
     */
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