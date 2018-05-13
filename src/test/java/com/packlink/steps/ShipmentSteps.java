package com.packlink.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObject.ShipmentsPage;

public class ShipmentSteps {
    @Then("^shipments screen is loaded$")
    public void shipments_screen_is_loaded() throws Throwable {
        new ShipmentsPage(CommonSteps.getDriver());
        ShipmentsPage.checkShipmentScreen();
    }

    @And("^proceed to create a new shipment$")
    public void proceed_to_create_a_new_shipment() throws Throwable {
        ShipmentsPage.clickCreateShipment();
    }
}
