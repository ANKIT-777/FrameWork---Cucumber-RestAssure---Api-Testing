package steps;
import Page.User;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class userLogin {

    private Response response;

    User user = new User();

    @When("the user logs in {string} and {string}")
    public void the_user_logs_in(String id , String pass) {
        response = user.userLogin(id,pass);
    }

    @Then("the user is logged in successfully")
    public void the_user_is_logged_in_successfully() {
        assertEquals(200, response.getStatusCode());
    }


}
