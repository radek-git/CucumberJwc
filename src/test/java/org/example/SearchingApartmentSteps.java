package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static com.google.common.truth.Truth.assertThat;

public class SearchingApartmentSteps extends BaseSteps {

    private HomePage homePage;
    private ResultPage resultPage;



    @Given("User opens page")
    public void user_opens_page() {
        open("https://jwc.pl/");
    }

    @Given("User closes warning pop-up")
    public void user_closes_warning_pop_up() {
        homePage = new HomePage();
        homePage.closeMessageAlert();
        homePage.closeCookieInfo();
        homePage.closeContactForm();
    }

    @Given("User selects location {string}")
    public void user_selects_location(String location) {
        homePage.clickLocationField(location);
    }

    @Given("User selects number of rooms {string}")
    public void user_selects_number_of_rooms(String rooms) {
        homePage.selectNumberOfRooms(rooms);
    }

    @Given("User selects living space from {string} to {string}")
    public void user_selects_living_space_from_to(String spaceFrom, String spaceTo) {
        homePage.selectSpaceFrom(spaceFrom);
        homePage.selectSpaceTo(spaceTo);
    }

    @Given("User selects property type {string}")
    public void user_selects_property_type(String propertyType) {
        homePage.selectPropertyType(propertyType);
    }

    @When("User selects Search button")
    public void user_selects_search_button() {
        homePage.clickSearchButton();
    }

    @Then("List of available apartments is displayed")
    public void list_of_available_apartments_is_displayed() {
        resultPage = new ResultPage();
        assertThat(resultPage.getResults() != 0);
    }

}
