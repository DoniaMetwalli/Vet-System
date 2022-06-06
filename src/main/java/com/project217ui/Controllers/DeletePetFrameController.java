package com.project217ui.Controllers;

import java.util.HashMap;
import com.project217ui.Models.PetModel;
import com.project217ui.Models.DoctorModel;

public class DeletePetFrameController {
    /**
     * Make the default constructor unavailable to prevent object creation
     */
    private DeletePetFrameController() {
    }

    /**
     * Searches the Database for a pet with @param petID and returns the info
     * associated with the ID in a HashMap with the property name as key
     * 
     * @param petID ID of the pet to be retrieved
     * @return HashMap of pet info with property name as key. Retrunes null if
     *         nothing was found.
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
     * Removes the newest pet ntry with @param petID from the database
     * 
     * @param petID ID of the pet to be removed
     * @return True if the pet was successfully removed
     */
    public static boolean RemovePet(String petID) {
        return DoctorModel.Instance().removePetFromDB(petID);
    }

}
