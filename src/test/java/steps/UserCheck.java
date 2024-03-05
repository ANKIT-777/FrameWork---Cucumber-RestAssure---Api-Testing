package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class UserCheck {

    Response response;

    private String baseUri;


    @When("I GET {string} and {string}")
    public void iGETAnd(String arg0, String arg1) {

        response = given()
                .get("https://petstore.swagger.io/v2" + arg0 + arg1);
        System.out.println(response.asString());
    }

    @Then("the user ID should be {int}")
    public void getId(int id){
        System.out.println(id);
        System.out.println(response.jsonPath().get("id") + "id");
    }
//
//    @Then("the username should be {string}")
//    public void the_username_should_be(String string) {
//        Assert.assertEquals(response.jsonPath().getString("username"),string);
//    }
//
//    @Then("the first name should be {string}")
//    public void the_first_name_should_be(String string) {
//        Assert.assertEquals(response.jsonPath().getString("firstName"),string);
//    }
//
//    @Then("the last name should be {string}")
//    public void the_last_name_should_be(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        Assert.assertEquals(response.jsonPath().getString("lastName"),string);
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the email should be {string}")
//    public void the_email_should_be(String string) {
//        Assert.assertEquals(response.jsonPath().getString("email"),string);
//
//    }
//
//    @Then("the password should be {string}")
//    public void the_password_should_be(String string) {
//
//        Assert.assertEquals(response.jsonPath().getString("password"),string);
//    }
//
//    @Then("the phone number should be {string}")
//    public void the_phone_number_should_be(String string) {
//
//        Assert.assertEquals(response.jsonPath().getString("phone"),string);
//    }
//
//    @Then("the status should be {int}")
//    public void the_user_status_should_be(Integer int1) {
//        Assert.assertEquals(Optional.of(response.jsonPath().getInt("phone")),int1);
//    }
//
//    @Then("the user status should be null")
//    public void the_user_status_should_be_null() {
//        Assert.assertNull(response.jsonPath().get("userStatus"));
//    }


}
