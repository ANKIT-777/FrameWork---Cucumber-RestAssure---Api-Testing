package steps;

import Page.PetRequest;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.awt.geom.RectangularShape;

public class updatePetSteps {
    PetRequest pet = new PetRequest();

    @Given("Call the pet with {int}")
    public void search_id(int id){
        Response response= pet.getPet(id);
        System.out.println(response.asString());
    }

    @And("Store previous id , name and status")
    public void store_previous_id_name_and_status() {

    }
    @When("i call for the pet update with the petid {int} , name {string} and status {string}")
    public void i_call_for_the_pet_update_with_the_petId_name_and_status(Integer int1, String string, String string2) {

    }
    @Then("Check the response status code")
    public void check_the_response_status_code() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("Check the response that name is changed or not")
    public void check_the_response_that_name_is_changed_or_not() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("Check the status is changed or not")
    public void check_the_status_is_changed_or_not() {
        // Write code here that turns the phrase above into concrete actions

    }

}
