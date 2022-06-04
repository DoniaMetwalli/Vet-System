package com.project217ui.Controllers;

import java.util.HashMap;

import com.project217ui.Models.DoctorModel;
import com.project217ui.Models.PetModel;

public class ViewPetFrameController {

    private ViewPetFrameController()
    {

    }
    public static HashMap<String,String> RetrievePetInfo(String petID)
    {
        HashMap<String,String> petInfo= new HashMap<>();
        PetModel pet =DoctorModel.Instance().findPetInDB(petID);
        if(pet==null)
            return null;
        petInfo.put("PetName", pet.getPetName());
        petInfo.put("OwnerName",pet.getOwnerName());
        petInfo.put("OwnerPhone", pet.getOwnerPhone());
        petInfo.put("PetBreed",pet.getBreed());
        petInfo.put("VisitReason", pet.getIssue());
        petInfo.put("Diagnosis",pet.getDiagnosis());
        petInfo.put("Age",Float.valueOf(pet.getAge()).toString());
        petInfo.put("Weight", Float.valueOf(pet.getWeight()).toString());
        return petInfo;
    }
    public static String UpdatePetInfo(String ownerName,String phoneNum,String petID,String petName,String petBreed,String petAge,String visitReason,String weight, String diagnosis)
    {
        PetModel pet = DoctorModel.Instance().findPetInDB(petID);
        try
        {
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
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        return "";
    }
}
