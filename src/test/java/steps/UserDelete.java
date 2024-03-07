package steps;

import Page.User;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Optional;

public class UserDelete {
    User client = new User();
    Response response;
    Response response1;

    @When("I Delete {string}")
    public void delete_user(String user){
        response= client.user_delete(user);
        System.out.println(response.asString());
    }

    @And("Check the response {int}")
    public void checkResponse(int code){
        Assert.assertEquals(response.getStatusCode(),code);
    }

    @And ( "I Check the user Details {string}")
    public void check_user(String string){

       response1 = client.getUser_info(string);

    }
    @Then("response status should be {int}")
    public void checkUserStatus(Integer status){
        Assert.assertEquals(Optional.ofNullable(status),response1.statusCode());
    }


}
