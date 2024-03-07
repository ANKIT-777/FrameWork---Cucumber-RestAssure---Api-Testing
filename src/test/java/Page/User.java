package Page;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class User {

    public Response getUser_info(String url){
        Response response = RestAssured.given().get(url);
        return  response;
    }


    public Response userPost(String endpoint, Map<String,Object> payload){

        Response response = RestAssured.given()
                                    .contentType(ContentType.JSON)
                                    .body(payload)
                                    .when()
                                    .post(endpoint);
        return  response;
    }

    public Response userLogin(String id, String pass){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user/login";
        Response response = given()
                .queryParam("username", id)
                .queryParam("password", pass)
                .header("accept", "application/json")
                .when()
                .get();
        return response;
    }

    public Response user_delete(String username){
        return given()
                .baseUri("https://petstore.swagger.io/v2/user/" + username)
                .when()
                .delete();
    }

}
