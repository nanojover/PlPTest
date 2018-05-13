package com.packlink.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObject.LoginPage;

public class LoginSteps {

    @When("^going to pro packlink login page$")
    public void going_to_pro_packlink_login_page() throws Throwable {
        CommonSteps.goToURL(CommonSteps.getProperties().getProperty("baseUrl")+"/login");
        new LoginPage(CommonSteps.getDriver());
    }

    @Given("^a registered user$")
    public void a_registered_user() throws Throwable {
        LoginPage.loginUser(
                CommonSteps.getProperties().getProperty("user"),
                CommonSteps.getProperties().getProperty(("password")));
    }

}
