package com.project217ui.Controllers;

import com.project217ui.Models.DoctorModel;

public class SignInController {
    /**
     * Make the default constructor unavailable to prevent object creation
     */
    private SignInController() {

    }

    /**
     * Check if the @param username and @param password combination exists in the
     * database
     * 
     * @param username Username of the doctor
     * @param password Password of the doctor
     * @return True if the combination exists in the database, False otherwise
     */
    public static boolean CheckLoginInfo(String username, String password) {
        return DoctorModel.Instance().login(username, password);
    }
}
