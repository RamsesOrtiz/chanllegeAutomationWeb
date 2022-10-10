package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.challenge.config.LoggerPage.*;
import static com.challenge.process.LoginProcess.*;
import static com.challenge.process.SignUpProcess.visitWebPage;

public class LogoutProcess extends ConfigPage {

    private static final Logger logger = logger(LogoutProcess.class);

    private static final By logoutLocator = By.id("logout2");

    public LogoutProcess(WebDriver driver) {
        super(driver);
    }

    public static boolean isLogged() {
        visitWebPage();
        selectLoginOption();
        fillData();
        LoginProcess.isLogged();
        return isLogged;
    }

    public static void selectLogoutOption() {
        waitAndClick(logoutLocator);
    }

    public static boolean isLogout() {
        if (isDisplayed(logoutLocator)) {
            logger.info("Logout Error");
            screenshot("Logout Error");
            return false;
        } else {
            logger.info("Logout Ok");
            screenshot("Logout OK");
            wait(3);
            return true;
        }
    }
}
