package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.challenge.config.LoggerPage.*;
import static com.challenge.config.PropertiesPage.*;
import static com.challenge.process.SignUpProcess.*;

public class LoginProcess extends ConfigPage {

    private static final Logger logger = logger(LoginProcess.class);

    public static boolean isLogged = false;

    private static final By loginLocator = By.id("login2");
    private static final By usernameLocator = By.id("loginusername");
    private static final By passwordLocator = By.id("loginpassword");
    private static final By loginSubmitLocator = By.cssSelector("[class='btn btn-primary'][onclick='logIn()']");
    private static final By userLoggedLocator = By.id("nameofuser");

    public LoginProcess(WebDriver driver) {
        super(driver);
    }

    public static boolean isSignUp() {
        return isSignUp;
    }

    public static void selectLoginOption() {
        waitAndClick(loginLocator);
    }

    public static void fillData() {
        waitAndClick(usernameLocator);
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginSubmitLocator);
        logger.info("Data filled OK");
    }

    public static boolean isLogged() {
        wait(3);
        if (getText(userLoggedLocator).contains(username)) {
            logger.info("Login OK");
            isLogged = true;
            screenshot("Login OK");
            return true;
        } else logger.info("Login Error");
        screenshot("Login Error");
        return false;
    }
}
