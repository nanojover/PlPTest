package com.packlink.steps;

import DTOs.RegisterDataDTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.RegisterPage;

import java.util.List;

public class RegisterSteps {
//    private RegisterPage registerPage;

    @Given("^an internet user on (Firefox|Chrome) browser$")
    public void an_internet_user_on_firefox_browser(String browser) throws Throwable {
        CommonSteps.startBrowser(browser);
    }

    @When("^going to pro packlink register page$")
    public void going_to_pro_packlink_register_page() throws Throwable {
        CommonSteps.goToURL(CommonSteps.getProperties().getProperty("baseUrl")+"/registro");
        new RegisterPage(CommonSteps.getDriver());
    }

    @When("^registered WITH credentials$")
    public void registered_with_credentials_(List<RegisterDataDTO> information) throws Throwable {
        RegisterPage.fillForm(information.get(0));
        RegisterPage.clickSubmit();
    }

    @Then("^it will see the registration form WITH required fields$")
    public void it_will_see_the_registration_form_with_5_required_fields() throws Throwable {
        RegisterPage.checkLoginScreen();
    }
    @Then("^an error message is displayed: \"([^\"]*)\"$")
    public void an_error_message_is_displayed_something(String errorMessage) throws Throwable {
        RegisterPage.checkErrorMessage(errorMessage);
    }
}
