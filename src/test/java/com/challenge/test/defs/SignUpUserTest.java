package com.challenge.test.defs;

import static com.challenge.process.SignUpProcess.*;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SignUpUserTest {

    @Given("a user visits the webpage")
    public void a_user_visits_the_webpage() {
        visitWebPage();
    }

    @When("select Sign up option")
    public void select_sign_up_option() {
        selectSignUpOption();
    }

    @When("fill in username and password fields")
    public void fill_in_username_and_password_fields() {
        fillData();
    }

    @Then("the system response is successful")
    public void the_system_response_is_successful() {
        Assert.assertTrue(isSignUp());
    }

    @After
    public void close(){
        quit();
    }
}
