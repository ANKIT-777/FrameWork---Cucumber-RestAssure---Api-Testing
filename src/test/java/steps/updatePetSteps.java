package steps;

import Page.PetRequest;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import java.awt.geom.RectangularShape;

public class updatePetSteps {
    PetRequest pet = new PetRequest();

    String ogName,ogStatus,newName,newStatus;
    Response checkresponse;
    Response updateresponse;

    @Given("Call the pet with {int}")
    public void search_id(int id){
        checkresponse= pet.getPet(id);

    }

    @And("Store previous id , name and status")
    public void store_previous_id_name_and_status() {
        ogName = checkresponse.jsonPath().getString("name");
        ogStatus = checkresponse.jsonPath().getString("status");
        System.out.println("The name which came is" + ogName + "and status is" + ogStatus);
    }
    @When("i call for the pet update with the petid {int} , name {string} and status {string}")
    public void i_call_for_the_pet_update_with_the_petId_name_and_status(int id, String name, String status) {
        updateresponse =pet.updatePet(id,name,status);
    }
    @Then("Check the response status code")
    public void check_the_response_status_code() {
        Assert.assertEquals(updateresponse.getStatusCode(),200);
    }
    @Then("Check the response that name is changed or not")
    public void check_the_response_that_name_is_changed_or_not() {
        newName = updateresponse.jsonPath().getString("name");

        System.out.println("The name which came is" + newName);
        Assert.assertNotEquals(newName,ogName);

    }
    @Then("Check the status is changed or not")
    public void check_the_status_is_changed_or_not() {
        newStatus = updateresponse.jsonPath().getString("status");
        System.out.println( "The new status is" + newStatus);
        Assert.assertNotEquals(newStatus,ogStatus);
    }

}
