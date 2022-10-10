package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.challenge.config.LoggerPage.*;
import static com.challenge.process.AddLaptopProcess.isAddedToCart;
import static com.challenge.process.AddLaptopProcess.*;
import static com.challenge.process.SignUpProcess.visitWebPage;

public class CheckCartProcess extends ConfigPage {

    private static final Logger logger = logger(CheckCartProcess.class);

    private static final By cartLocator = By.id("cartur");
    private static final By productInCartLocator = By.xpath("//*[@id='tbodyid']/tr[1]/td[2]");

    public CheckCartProcess(WebDriver driver) {
        super(driver);
    }

    public static boolean isAddedToCart() {
        visitWebPage();
        selectLaptopMenu();
        selectLaptop();
        addToCart();
        AddLaptopProcess.isAddedToCart();
        return isAddedToCart;
    }

    public static void selectCartOption() {
        waitAndClick(cartLocator);
    }

    public static boolean isPresent() {
        waitElement(productInCartLocator, 5);
        if(getText(productInCartLocator).contentEquals(productSelected)){
            screenshot("Check Cart OK");
            logger.info("Check Cart OK");
            return true;
        }else {
            screenshot("Check Cart Error");
            logger.info("Check Cart Error");
            return false;
        }
    }
}
