package com.challenge.test.defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static com.challenge.process.SignUpProcess.visitWebPage;

import static com.challenge.process.AddLaptopProcess.*;

public class AddLaptopToCartTest {

    @Given("a user visits the homepage")
    public void a_user_visits_the_homepage() {
        visitWebPage();
    }

    @When("goes to Laptops Categories")
    public void goes_to_laptops_categories() {
        selectLaptopMenu();
    }

    @When("select some laptop")
    public void select_some_laptop() {
        selectLaptop();
    }

    @When("select add to cart option")
    public void select_add_to_cart_option() {
        addToCart();
    }

    @Then("the system confirm that the product was added")
    public void the_system_confirm_that_the_product_was_added() {
        Assert.assertTrue(isAddedToCart());
    }

    @After
    public void close(){
        quit();
    }
}
