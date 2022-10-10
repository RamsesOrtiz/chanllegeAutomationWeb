package com.challenge.test.defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.challenge.process.LogoutProcess.*;

public class LogoutUserTest {

    @Given("a user logged in the webpage")
    public void a_user_logged_in_the_webpage() {
        Assert.assertTrue(isLogged());
    }

    @When("select Logout option")
    public void select_logout_option() {
        selectLogoutOption();
    }

    @Then("the system logout successfully")
    public void the_system_logout_successfully() {
        Assert.assertTrue(isLogout());
    }

    @After
    public void close() {
        quit();
    }
}
