package com.project217ui.Controllers;

import com.project217ui.Models.DoctorModel;

public class SignInController {
    private SignInController()
    {

    }
    public static boolean CheckLoginInfo(String username, String password)
    {
        return DoctorModel.Instance().login(username,password);
    }
}
