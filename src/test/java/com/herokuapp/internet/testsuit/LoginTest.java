package com.herokuapp.internet.testsuit;

import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials(){

        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnSignInButton();
        String expected="Secure Area";
       Assert.assertEquals(loginPage.verifyText(),"Secure Area","not verify");

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnSignInButton();
        //String expected = "Your username is invalid!";
        //Assert.assertEquals(loginPage.verifyText()," Your username is invalid!","not verify");
        String expectedText = "Your username is invalid!\n" +
                "×";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(actualText,expectedText,"Your username is invalid!");
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnSignInButton();
        //String expected = "Your password is invalid!";
        //Assert.assertEquals(loginPage.verifyText()," Your password is invalid!","Your password is invalid!");
        String expectedText = "Your password is invalid!\n" +
                "×";
        String actualText = loginPage.getErrorMessage1();
        Assert.assertEquals(actualText,expectedText,"Your password is invalid!");
    }
}

