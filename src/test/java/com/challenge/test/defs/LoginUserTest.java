package com.challenge.test.defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static com.challenge.process.SignUpProcess.visitWebPage;
import static com.challenge.process.LoginProcess.*;

public class LoginUserTest {

    @Given("a user sign up in the webpage")
    public void a_user_sign_up_in_the_webpage() {
        visitWebPage();
        Assert.assertTrue(isSignUp());
    }

    @When("select Login option")
    public void select_login_option() {
        selectLoginOption();
    }

    @When("write the username and password fields")
    public void write_the_username_and_password_fields() {
        fillData();
    }

    @Then("the system login successfully")
    public void the_system_login_successfully() {
        Assert.assertTrue(isLogged());
    }

    @After
    public void close(){
        quit();
    }
}
