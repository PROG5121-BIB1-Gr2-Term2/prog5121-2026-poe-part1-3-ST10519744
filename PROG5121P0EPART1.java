/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121p0epart1;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class PROG5121P0EPART1 {

    public static void main(String[] args) {
          
        //declarations
        String username;
        String password;
        String cellphone; 
   
        // prompt user input for registaring
          Scanner input = new Scanner(System.in);
        System.out.println("Please enter registration details");
        System.out.print("Enter username: ");
        username = input.nextLine();
        boolean correctusername = Login.checkUserName(username);
        if (correctusername) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure "
                    + "that your username contains an underscore and is no more than five characters in length");
        }
        System.out.print("Enter password: ");
        password = input.nextLine();
        boolean correctpassword = Login.checkPassword(password);
        if (correctpassword) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure "
                    + "that the password contains at least 8 characters, a capital letter, a number and a special character..");
        }
        System.out.print("Enter SA cellphone (+27): ");
        cellphone = input.nextLine();
        boolean correctcellphone = Login.checkCellPhone(cellphone);
        if (correctcellphone) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
        }
        boolean isRegistered = false;
        // registration check
        if (correctusername&& correctpassword && correctcellphone) {
            Login.registerUser(username, password);
            isRegistered = true;
            System.out.println("Registration successfully.");
        } else {
            System.out.println("Registration failed.");
        }
        if (!isRegistered) {
            System.out.println("You cannot login because your attempt to register  failed.");
            return;
        }
        //prompt user input for log in
        System.out.println("Please enter your login details");
        System.out.println("Enter username");
        String loginUser = input.nextLine();
        System.out.print("Enter password");
        String loginPass = input.nextLine();
        boolean status = Login.loginUser(loginUser, loginPass);
        System.out.println(Login.returnLoginStatus(status, loginUser));
    }
}
// login class
class Login {

    static String storedUsername;
    static String storedPassword;

    // checking username
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // checking password
    public static boolean checkPassword(String password) {

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return password.length() >= 8 && hasUpper && hasNumber && hasSpecial;
    }
 
    
    // checking cellphone number
    public static boolean checkCellPhone(String cellphone) {
        return cellphone.startsWith("+27") && cellphone.length() == 12;
    }
    
    public static void registerUser(String username, String password) {
        storedUsername = username;
        storedPassword = password;
    }
    public static boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // login message
    public static String returnLoginStatus(boolean status, String username) {
        if (status) {
            return "Welcome " + username + ", you are now logged in.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
    

