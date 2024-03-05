package steps;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static utills.userPayload.createPayload;

public class UserApi {

    private Response response;
    private RequestSpecification request;
    String baseUri;

    @Given("http baseUri is {string}")
    public void setBaseUri(String endpoint) {
        baseUri = endpoint;
    }


    @When("I set body to post user with details")
    public void dataSetter(List<Map<String, String>> data){
        Map<String, String> userData = data.get(0);
        Map<String, Object> payload = createPayload(userData.get("id"), userData.get("username"), userData.get("firstname"),
                userData.get("lastname"), userData.get("email"), userData.get("password"),
                userData.get("phone"), userData.get("userStatus"));

        request = RestAssured.given();
        request.contentType(ContentType.JSON).body(payload);

    }

    @And("I POST {string}")
    public void sendingRequest(String endpoint){

        response = request.post(baseUri + endpoint);
    }

    @Then("http response code should be {int}")
    public void verifyResponseCode(int statusCode) {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());
    }

    @Then("http response header Content-Type should be {string}")
    public void verifyContentTypeNot(String contentType) {
        String type = response.then().extract().header("Content-Type");
        Assert.assertEquals(contentType, type);
    }



}
