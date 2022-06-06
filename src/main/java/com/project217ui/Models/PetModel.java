package com.project217ui.Models;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class PetModel {
    /**
     * HashMap of usedIDs with the ID as key and Pet Name as value to prevent
     * creation of pets with same ID
     */
    private static HashMap<String, String> usedIDs = new HashMap<String, String>();
    
    /**
     * Copy Constructor
     * 
     * @param o_Pet Original Pet to be copied
     */
    public PetModel(PetModel o_Pet) {
        this(new String(o_Pet.getPetName()), new String(o_Pet.getOwnerName()), new String(o_Pet.getOwnerPhone()),
                new String(o_Pet.getPetID()), new String(o_Pet.getBreed()), o_Pet.getAge(), o_Pet.getWeight(),
                new String(o_Pet.getIssue()), new String(o_Pet.getDiagnosis()));
    }

    /**
     * Creates a Pet Object with only the essential data
     * 
     * @param o_PetName   Name of the pet
     * @param o_OwnerName Name of the Owner
     * @param o_PetID     ID of the Pet
     * @param o_Issue     Reason for Visiting the clinic
     * @param o_Diagnosis Doctor's Analysis of the Issue
     * @throws IllegalArgumentException If incorrect data formatting was given
     */
    public PetModel(String o_PetName, String o_OwnerName, String o_PetID, String o_Issue, String o_Diagnosis)
            throws IllegalArgumentException {
        setPetName(o_PetName);
        setOwnerName(o_OwnerName);
        setPetID(o_PetID);
        setIssue(o_Issue);
        setDiagnosis(o_Diagnosis);
        m_Visits = new ArrayList<VisitModel>();
    }

    /**
     * Creates a Pet Object with all fields
     * 
     * @param o_PetName    Name of the pet
     * @param o_OwnerName  Name of the Owner
     * @param o_OwnerPhone Phone Number of the Owner
     * @param o_PetID      ID of the Pet
     * @param o_Breed      Specie and Breed of the Pet
     * @param o_Age        Age of the Pet
     * @param o_Weight     Weight of the Pet
     * @param o_Issue      Reason for Visiting the clinic
     * @param o_Diagnosis  Doctor's Analysis of the Issue
     * @throws IllegalArgumentException If incorrect data formatting was given
     */
    public PetModel(String o_PetName, String o_OwnerName, String o_OwnerPhone, String o_PetID, String o_Breed,
            float o_Age, float o_Weight,
            String o_Issue, String o_Diagnosis) throws IllegalArgumentException {
        setPetName(o_PetName);
        setOwnerName(o_OwnerName);
        setOwnerPhone(o_OwnerPhone);
        setPetID(o_PetID);
        setBreed(o_Breed);
        setAge(o_Age);
        setWeight(o_Weight);
        setIssue(o_Issue);
        setDiagnosis(o_Diagnosis);
        m_Visits = new ArrayList<VisitModel>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (((PetModel) o).getPetID() == this.getPetID() && ((PetModel) o).getPetName() == this.getPetName())
            return true;
        return false;
    }

    /**
     * 
     * @return Pet Name field of the object
     */
    public String getPetName() {
        return m_PetName;
    }

    /**
     * 
     * @param o_PetName New Pet name to be assigned to this object
     */
    public void setPetName(String o_PetName) {
        this.m_PetName = o_PetName;
    }

    /**
     * 
     * @return Owner Name Field of the object
     */
    public String getOwnerName() {
        return m_OwnerName;
    }

    /**
     * @param o_OwnerName New Name of the Owner
     * @throws IllegalArgumentException if the new name contains Non-Alphabetic
     *                                  characters
     */
    public void setOwnerName(String o_OwnerName) throws IllegalArgumentException {
        if (ContainsNonAlpha(o_OwnerName))
            throw new IllegalArgumentException("Name can not contain non-alphabetic characters");
        this.m_OwnerName = o_OwnerName;
    }

    /**
     * 
     * @return Phone number field of the Object
     */
    public String getOwnerPhone() {
        return m_OwnerPhone;
    }

    /**
     * 
     * @param o_OwnerPhone New Phone Number of the Owner
     * @throws IllegalArgumentException if the phone numebr contains non-digits
     */
    public void setOwnerPhone(String o_OwnerPhone) throws IllegalArgumentException {
        if (checkInvalidPhoneNum(o_OwnerPhone))
            throw new IllegalArgumentException("Phone number can only contain digits or + sign");
        this.m_OwnerPhone = o_OwnerPhone;
    }

    /**
     * @return Pet ID field of the object
     */
    public String getPetID() {
        return m_PetID;
    }

    /**
     * 
     * @param o_PetID New ID of the Pet
     * @throws IllegalArgumentException if the ID is already used by another Pet
     */
    public void setPetID(String o_PetID) throws IllegalArgumentException {
        System.out.println(m_PetName+" "+ usedIDs.get(o_PetID));
        if ((usedIDs.keySet().contains(o_PetID)) && !this.m_PetName.equals(usedIDs.get(o_PetID)))
            throw new IllegalArgumentException("ID already in use");
        usedIDs.remove(this.m_PetID);
        this.m_PetID = o_PetID;
        usedIDs.put(this.m_PetID, this.getPetName());
    }

    /**
     * 
     * @return Pet Breed field of the Object
     */
    public String getBreed() {
        return m_Breed;
    }

    /**
     * 
     * @param o_Breed New Breed to be assigned to the object
     */
    public void setBreed(String o_Breed) {
        this.m_Breed = o_Breed;
    }

    /**
     * 
     * @return Pet Age field of the object
     */
    public float getAge() {
        return m_Age;
    }

    /**
     * 
     * @param o_Age New Age of the Pet
     * @throws IllegalArgumentException if the Age is equal to Zero or less
     */
    public void setAge(float o_Age) throws IllegalArgumentException {
        if (o_Age <= 0)
            throw new IllegalArgumentException("Age Cannot be less than or equal to 0");
        this.m_Age = o_Age;
    }

    /**
     * 
     * @return Current Issue with the pet
     */
    public String getIssue() {
        return m_Issue;
    }

    /**
     * @param o_Issue New issue of the Pet
     */
    public void setIssue(String o_Issue) {
        this.m_Issue = o_Issue;
    }

    /**
     * 
     * @return Current Diagnosis of the pet
     */
    public String getDiagnosis() {
        return m_Diagnosis;
    }

    /**
     * 
     * @param o_Diagnosis New Diagnosis of the Pet
     */
    public void setDiagnosis(String o_Diagnosis) {
        this.m_Diagnosis = o_Diagnosis;
    }

    /**
     * 
     * @return weight of the Pet
     */
    public float getWeight() {
        return m_Weight;
    }

    /**
     * 
     * @param o_Weight new Wieght of the Pet
     * @throws IllegalArgumentException if the weight is less than or equal to Zero
     */
    public void setWeight(float o_Weight) throws IllegalArgumentException {
        if (o_Weight < 0)
            throw new IllegalArgumentException("Weight can't be less than 0");
        this.m_Weight = o_Weight;
    }

     public int getVisitIndex(VisitModel o_Visit)
    {
        return m_Visits.indexOf(o_Visit);
    }


    public void addVisit(VisitModel o_Visit)
    {
        m_Visits.add(o_Visit);
    } 

    
    public void addVisits(Collection<? extends VisitModel> o_Visits)
    {
        m_Visits.addAll(o_Visits);
    }

    
    public VisitModel getVisit(int visitIndex)
    {
        return m_Visits.get(visitIndex);
    }


    public void removeVisit(VisitModel o_Visit)
    {
        m_Visits.remove(o_Visit);
    }    


    public void removeVisit(int o_VisitIndex)
    {
        m_Visits.remove(o_VisitIndex);
    }
    
    
    public ArrayList<VisitModel> getVisits(String complaint)
    {
        ArrayList<VisitModel> subList = new ArrayList<VisitModel>();
        for (VisitModel v : m_Visits)
        {
            if(v.getComplaint().contains(complaint))
                subList.add(v);
        }
        return subList;
    }

    public VisitModel getLastVisit ()
    {
        return m_Visits.get(m_Visits.size()-1);
    }
    @Override
    public String toString() {
        return new String("Pet name: " + this.m_PetName + "\nOwner name: " + this.m_OwnerName + "\nOwner phone: "
                + this.m_OwnerPhone + "\nPet ID: " + this.m_PetID + "\nBreed: " + this.m_Breed + "\nAge: " + this.m_Age
                + "\nIssue: " + this.m_Issue + "\nDiagnosis: " + m_Diagnosis);
    }

    /**
     * Helper function that checks if the string contains none alphabetic characters
     * 
     * @param other to be checked String
     * @return True if it contains none Alphabetic characters, False otherwise
     */
    private boolean ContainsNonAlpha(String other) {
        for (char c : other.toCharArray()) {
            if (!(Character.isWhitespace(c) || Character.isAlphabetic(c)))
                return true;
        }
        return false;
    }

    /**
     * Helper function that checks if the string contains non-digits except for the
     * + sign
     * 
     * @param other to be checked string
     * @return True if it contains non Digits
     */
    private boolean checkInvalidPhoneNum(String other) {
        for (char c : other.toCharArray()) {
            if (!(Character.isDigit(c) || c == '+'))
                return true;
        }
        return false;
    }

    private String m_PetName = "N/A";
    private String m_OwnerName = "N/A";
    private String m_OwnerPhone = "N/A";
    private String m_PetID = "N/A";
    private String m_Breed = "N/A";
    private float m_Age = -1;
    private float m_Weight = -1;
    private String m_Issue = "N/A";
    private String m_Diagnosis = "N/A";
    private ArrayList<VisitModel> m_Visits; 
}
