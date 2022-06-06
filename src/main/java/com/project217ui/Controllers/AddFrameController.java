package com.project217ui.Controllers;

import com.project217ui.Models.DoctorModel;

public class AddFrameController {
    /**
     * Make the default constructor unavailable to prevent object creation
     */
    private AddFrameController() {

    }

    /**
     * Calls the model to add pet to the database
     * 
     * @param ownerName   Name of the Owner of the pet
     * @param phoneNum    Phone Number of the Owner
     * @param petID       ID of the Pet
     * @param petName     Name of the pet
     * @param petBreed    Breed of the pet
     * @param petAge      Age of the pet
     * @param visitReason The issue for which th epet came to the clinic
     * @param weight      Weight of the pet
     * @param diagnosis   Diagnosis of the Issue/Visit Reason
     * @return The error message returned by the database. If it was successfully
     *         added an empty string is returned
     */
    public static String AddPet(String ownerName, String phoneNum, String petID, String petName, String petBreed,
            String petAge, String visitReason, String weight, String diagnosis) {
        try {
            return DoctorModel.Instance().AddPetToDB(petName, ownerName, phoneNum, petID, petBreed,
                    Float.parseFloat(petAge), Float.parseFloat(weight), visitReason, diagnosis) ? ""
                            : "Failed to add: Duplicate ID";

        } catch (Exception e) {
            return "Failed to add: \n" + e.getMessage();
        }
    }
}
