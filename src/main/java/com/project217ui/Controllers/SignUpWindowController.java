package com.project217ui.Controllers;

import com.project217ui.Models.DoctorModel;

public class SignUpWindowController {
    // Make the default constructor unavailable to prevent object creation
    private SignUpWindowController() {

    }

    /**
     * Try to add a doctor with @param o_UserName and @param o_Password to the
     * database
     * 
     * @param o_UserName username of the new doctor
     * @param o_Password password of the new doctor
     * @return True if the doctor was added successfully, False otherwise
     */
    public static boolean SignUp(String o_UserName, String o_Password) {
        return DoctorModel.Instance().signUp(o_UserName, o_Password);
    }
}
