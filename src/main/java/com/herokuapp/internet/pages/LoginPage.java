package com.herokuapp.internet.pages;

import com.google.common.annotations.VisibleForTesting;
import com.herokuapp.internet.utility.Utility;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By username = By.id("username");
    By password = By.id("password");
    By LoginText = By.xpath("//i[contains(text(),'Login')]");
    //By verifyMessage = By.xpath("//h2[normalize-space()='Secure Area']");
    By verifyMessage = By.xpath("//*[@id=\"content\"]/div/h2");

    By errorMessage= By.xpath("//div[contains(text(),'Your username is invalid!')]");
    By errorMessage1=By.xpath("//div[contains(text(),'Your password is invalid!')]");
    public void enterUserName(String username2) {
        sendTextToElement(username, username2);
    }

    public void enterPassword(String password1) {
        sendTextToElement(password, password1);
    }
    public void clickOnSignInButton() {
        clickOnElement(LoginText);
    }

    public String verifyText() {
        return getTextFromElement(verifyMessage);

    }
    public String getErrorMessage (){
        return getTextFromElement(errorMessage);

    }
    public String getErrorMessage1(){
        return getTextFromElement(errorMessage1);
    }
}