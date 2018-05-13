package com.packlink.steps;

import DTOs.SearchDataDTO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObject.ShipmentsCreateInfoPage;

import java.util.List;

public class ShipmentsCreateInfoSteps {
    @And("^shipments create infor is loaded$")
    public void shipments_create_infor_is_loaded() throws Throwable {
        new ShipmentsCreateInfoPage(CommonSteps.getDriver());
        ShipmentsCreateInfoPage.checkShipmentCreateOmfpScreen();
    }

    @When("^performing a search with the following information:$")
    public void performing_a_search_with_the_following_information(List<SearchDataDTO> information) throws Throwable {
        ShipmentsCreateInfoPage.fillForm(information.get(0));
        ShipmentsCreateInfoPage.clickCreateShipmentButton();
    }
}
