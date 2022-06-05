package com.project217ui.Controllers;

import com.project217ui.Models.DoctorModel;
import com.project217ui.Models.PetModel;

public class AddFrameController {
    public static String AddPet(String ownerName,String phoneNum,String petID,String petName,String petBreed,String petAge,String visitReason,String weight, String diagnosis)
    {
        try
        {
            return DoctorModel.Instance().AddPetToDB(petName,ownerName,phoneNum,petID,petBreed,Float.parseFloat(petAge),Float.parseFloat(weight), visitReason, diagnosis)?"":"Failed to add: Duplicate ID";

        }
        catch (Exception e)
        {
            return "Failed to add: \n"+ e.getMessage();
        }
    }
}
