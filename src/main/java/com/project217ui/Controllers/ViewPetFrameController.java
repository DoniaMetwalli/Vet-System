package com.project217ui.Controllers;

import java.util.HashMap;

import com.project217ui.Models.DoctorModel;
import com.project217ui.Models.PetModel;

public class ViewPetFrameController {

    /**
     * Make the default constructor unavailable to prevent object creation
     */
    private ViewPetFrameController() {

    }

    /**
     * Retrieves pet info whose ID matches @param petID from the database
     * 
     * @param petID ID of the pet whose data should be views
     * @return HashMap of the pet info where the Key is the property name and value
     *         is the prorperty value
     */
    public static HashMap<String, String> RetrievePetInfo(String petID) {
        HashMap<String, String> petInfo = new HashMap<>();
        PetModel pet = DoctorModel.Instance().findPetInDB(petID);
        if (pet == null)
            return null;
        petInfo.put("PetName", pet.getPetName());
        petInfo.put("OwnerName", pet.getOwnerName());
        petInfo.put("OwnerPhone", pet.getOwnerPhone());
        petInfo.put("PetBreed", pet.getBreed());
        petInfo.put("VisitReason", pet.getIssue());
        petInfo.put("Diagnosis", pet.getDiagnosis());
        petInfo.put("Age", Float.valueOf(pet.getAge()).toString());
        petInfo.put("Weight", Float.valueOf(pet.getWeight()).toString());
        return petInfo;
    }

    /**
     * Updates pet's data that has @param petID
     * 
     * @param ownerName   Updated Name of the owner
     * @param phoneNum    Updated Phone number
     * @param petID       Searched Pet ID
     * @param petName     Updated Pet Name
     * @param petBreed    Updated pet breed
     * @param petAge      Updated Pet Age
     * @param visitReason Updated Visit Reason
     * @param weight      Updated Weight
     * @param diagnosis   Updated Diagnosis
     * @return Error message, if update is successful, returns an empty string
     */
    public static String UpdatePetInfo(String ownerName, String phoneNum, String petID, String petName, String petBreed,
            String petAge, String visitReason, String weight, String diagnosis) {
        // Retrieve pet Info from database and update the PetModel objecy
        PetModel pet = DoctorModel.Instance().findPetInDB(petID);
        try {
            pet.setAge(Float.parseFloat(petAge));
            pet.setBreed(petBreed);
            pet.setDiagnosis(diagnosis);
            pet.setIssue(visitReason);
            pet.setOwnerName(ownerName);
            pet.setOwnerPhone(phoneNum);
            pet.setPetID(petID);
            pet.setPetName(petName);
            pet.setWeight(Float.parseFloat(weight));
            DoctorModel.Instance().updatePetInDB(pet);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }
}
