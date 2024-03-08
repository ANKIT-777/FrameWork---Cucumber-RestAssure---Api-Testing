package steps;

import Page.PetRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class postPetSteps {

    PetRequest petRequest = new PetRequest();
    Response response;
    @Given("I create a pet with the following details:")
    public void i_create_a_pet_with_the_following_details(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            int id = Integer.parseInt(row.get("id"));
            String name = row.get("name");
            String status = row.get("status");
            int catId = Integer.parseInt(row.get("catId"));
            String catName = row.get("catName");
            int tagId = Integer.parseInt(row.get("tagId"));
            String tagName = row.get("tagName");
            String photoUrl = row.get("photoUrl");
            petRequest.petCreator(id, name, status, catId, catName, tagId, tagName, photoUrl);
        }

    }

    @When("i send request to create user")
    public void createThePet() {
        response = petRequest.postPet();
    }

    @Then("the pet payload should be created successfully")
    public void CheckStatuscode(){
        System.out.println(response.asString());
    }





}
