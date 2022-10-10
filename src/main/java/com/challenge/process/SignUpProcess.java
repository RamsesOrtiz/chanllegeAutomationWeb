package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.challenge.config.PropertiesPage.*;
import static com.challenge.config.LoggerPage.*;

public class SignUpProcess extends ConfigPage {

    private static final Logger logger = logger(SignUpProcess.class);

    public static boolean isSignUp = false;

    private static final By singInLocator = By.id("signin2");
    private static final By singUsernameLocator = By.id("sign-username");
    private static final By signPasswordLocator = By.id("sign-password");
    private static final By signUpSubmitLocator = By.cssSelector("[class='btn btn-primary'][onclick='register()']");

    public SignUpProcess(WebDriver driver) {
        super(driver);
    }

    public static void visitWebPage() {
        setup(browser);
        visit(URL);
        logger.info("Url Ok: " + URL);
    }

    public static void selectSignUpOption() {
        waitAndClick(singInLocator);
    }

    public static void fillData() {
        waitAndClick(singUsernameLocator);
        type(username, singUsernameLocator);
        type(password, signPasswordLocator);
        click(signUpSubmitLocator);
        logger.info("Data filled OK");
        wait(3);
        manageAlert();
    }

    public static boolean isSignUp() {
        if(isDisplayed(signUpSubmitLocator)){
            logger.info("SignUp Error");
            screenshot("SignUp Error");
            return false;
        } else {
            logger.info("SignUp OK");
            screenshot("SignUpOk");
            isSignUp = true;
            return true;
        }
    }
}
