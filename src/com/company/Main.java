package com.company;


public class Main {

    public static void main(String[] args) {

        SignIn user = new SignIn("Naruto015", "qwer_Ty", "qwer_Ty1");
        SignIn.signInAcc(user.getLogin(), user.getPassword(), user.getConfirmPassword());


    }


}

