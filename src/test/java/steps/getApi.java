package steps;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getApi {

    private String baseUrl;
    private Response response;

    @Given("I have the base URL {string}")
    public void setBaseUrl(String url) {
        baseUrl = url;
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = RestAssured.get(baseUrl + endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response body should contain {string}")
    public void verifyResponseBody(String expectedBody) {
        String responseBody = response.getBody().jsonPath().getString("page");
        assertTrue(responseBody.contains(expectedBody));
    }
}
