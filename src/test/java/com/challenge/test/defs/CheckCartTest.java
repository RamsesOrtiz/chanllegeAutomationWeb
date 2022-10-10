package com.challenge.test.defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static com.challenge.process.CheckCartProcess.*;

public class CheckCartTest {

    @Given("a user who added a Laptop to cart")
    public void a_user_who_added_a_laptop_to_cart() {
        Assert.assertTrue(isAddedToCart());
    }

    @When("goes to Cart option")
    public void goes_to_cart_option() {
        selectCartOption();
    }

    @Then("the product added is present in the cart")
    public void the_product_added_is_present_in_the_cart() {
        Assert.assertTrue(isPresent());
    }

    @After
    public void close(){
        quit();
    }
}
