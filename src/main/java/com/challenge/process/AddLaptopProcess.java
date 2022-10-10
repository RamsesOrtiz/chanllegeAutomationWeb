package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import static com.challenge.config.LoggerPage.*;

public class AddLaptopProcess extends ConfigPage {

    private static final Logger logger = logger(AddLaptopProcess.class);

    public static boolean isAddedToCart = false;

    private static final By laptopMenuLocator = By.cssSelector("a[id='itemc'][onclick*='notebook']");
    private static final By laptopSelectedLocator = By.cssSelector("a[href='prod.html?idp_=8'][class='hrefch']");
    private static final By addToCartLocator = By.cssSelector("a[onclick='addToCart(8)']");

    public static String productSelected;

    public AddLaptopProcess(WebDriver driver) {
        super(driver);
    }

    public static void selectLaptopMenu(){
        waitAndClick(laptopMenuLocator);
        wait(5);
    }

    public static void selectLaptop(){
        productSelected = getText(laptopSelectedLocator);
        waitAndClick(laptopSelectedLocator);
    }

    public static void addToCart(){
        waitAndClick(addToCartLocator);
    }

    public static boolean isAddedToCart(){
        try{
            wait(3);
            manageAlert();
            logger.info("Product was added to cart");
            screenshot("Product added OK");
            isAddedToCart = true;
            return true;
        } catch (NoAlertPresentException e){
            logger.error(e);
            screenshot("Product added error");
            return false;
        }
    }
}
