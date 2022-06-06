package com.project217ui.Controllers;

import com.project217ui.Models.DoctorModel;

public class SignUpWindowController {
    private SignUpWindowController()
    {

    }
    public static boolean SignUp(String o_UserName, String o_Password)
    {
        return DoctorModel.Instance().signUp(o_UserName, o_Password);
    }    
}
