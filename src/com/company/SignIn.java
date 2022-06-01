package com.company;

import java.util.regex.Pattern;

public class SignIn {
    private String login;
    private String password;
    private String confirmPassword;


    public SignIn(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public static void signInAccount(String login, String password, String confirmPassword) {
        if (login.length() > 20 || Pattern.matches("[а-яА-Я]+", login)) {
            System.out.println(login + "= " + false);
            throw new WrongLoginException();
        } else if (password.length() > 20 || !password.equals(confirmPassword) || Pattern.matches("[а-яА-Я]+", password)) {
            System.out.println("password " + password + "= " + false);

            throw new WrongPasswordException();
        } else if (Pattern.matches("[а-яА-Я]+", confirmPassword)) {
            System.out.println("confirm_password " + confirmPassword + "= " + false);
            throw new WrongConfirmPasswordException();

        } else if (login.length() <= 20 || Pattern.matches("[a-zA-Z0-9_]+", login)) {

            System.out.println("login " + login + "= " + true);

        } else if (password.length() < 20 || Pattern.matches("[a-zA-Z0-9_]+", password)) {

            System.out.println("password " + password + "= " + true);

        } else if (confirmPassword.equals(password) || Pattern.matches("[a-zA-Z0-9_]+", confirmPassword)) {

            System.out.println("confirm_password " + confirmPassword + "= " + true);

        }
    }


    public static boolean signInAcc(String login, String password, String confirmPassword) {
        try {
            signInAccount(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return false;
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return false;
        } catch (WrongConfirmPasswordException e) {
            e.printStackTrace();
            return false;
        } finally {
            System.out.println("done");
        }
    }
}

