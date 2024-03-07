package steps;

import Page.User;
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

    
    User user1 = new User();


    @When("I GET {string} and {string}")
    public void iGETAnd(String endpoint, String user) {
        response = user1.getUser_info( endpoint + user);
        System.out.println(endpoint + user);
        System.out.println(response.asString());
    }

    @Then("the user ID should be {int}")
    public void getId(int id){
        Assert.assertEquals(id,response.jsonPath().getInt("id"));
    }

    @Then("the username should be {string}")
    public void the_username_should_be(String string) {
        Assert.assertEquals(response.jsonPath().getString("username"),string);
    }

    @Then("the email should be {string}")
    public void the_email_should_be(String string) {
        Assert.assertEquals(response.jsonPath().getString("email"),string);

    }

    @Then("the password should be {string}")
    public void the_password_should_be(String string) {

        Assert.assertEquals(response.jsonPath().getString("password"),string);
    }



}
