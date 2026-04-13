/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121p0epart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUserNameCorrectlyFormatted() {
        assertTrue(Login.checkUserName("kyl_1"));
    }
    @Test
    public void testUserNameIncorrectlyFormatted() {
        assertFalse(Login.checkUserName("kyle!!!!!!!"));
    }
    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(Login.checkPassword("Ch&sec@ke99"));
    }
    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse(Login.checkPassword("password"));
    }
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue(Login.checkCellPhone("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse(Login.checkCellPhone("08966553"));
    }
    @Test
    public void testLoginSuccessful() {
        Login.registerUser("kyl_1", "Ch&sec@ke99");
        assertTrue(Login.loginUser("kyl_1", "Ch&sec@ke99"));
    }
    @Test
    public void testLoginFailed() {
        Login.registerUser("kyl_1", "Ch&sec@ke99");
        assertFalse(Login.loginUser("wrong", "wrong"));
    }
    @Test
    public void testReturnLoginStatusSuccess() {
        String result = Login.returnLoginStatus(true, "kyl_1");
        assertEquals("Welcome kyl_1, it is great to see you again.", result);
    }
    @Test
    public void testReturnLoginStatusFail() {
        String result = Login.returnLoginStatus(false, "kyl_1");
        assertEquals("Username or password incorrect, please try again.", result);
    }
}
