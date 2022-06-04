package com.project217ui.Controllers;
import java.util.HashMap;
import com.project217ui.Models.PetModel;
import com.project217ui.Models.DoctorModel;
public class DeletePetFrameController {
    private DeletePetFrameController()
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
    public static boolean RemovePet(String petID)
    {
        return DoctorModel.Instance().removePetFromDB(petID);
    }

}
