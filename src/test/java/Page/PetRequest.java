package Page;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utills.PetPOJO.Cat;
import utills.PetPOJO.Pet;
import utills.PetPOJO.Tag;

import static io.restassured.RestAssured.*;

public class PetRequest {

    String payload;

    public void petCreator(int id, String name, String status, int catId, String catName, int tagId, String tagName, String photourl){
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setStatus(status);

        Cat category = new Cat();
        category.setId(catId);
        category.setName(catName);
        pet.setCategory(category);

        Tag tag = new Tag();
        tag.setId(tagId);
        tag.setName(tagName);
        pet.setTags(new Tag[]{tag});

        pet.setPhotoUrls(new String[]{photourl});
        Gson gson = new Gson();
        payload = gson.toJson(pet);
    }

    public Response postPet(){

        Response response = given().
                            contentType(ContentType.JSON).baseUri("https://petstore.swagger.io/v2").
                            body(payload).post("/pet");

        return response;
    }

    public Response getPet(int id){
        String baseUrl = "https://petstore.swagger.io/v2";
        return given().baseUri(baseUrl).get("/pet/" + id);
    }


    public Response updatePet(int petId,String updatedName,String updatedStatus){
        String baseUrl = "https://petstore.swagger.io/v2";
        Response response = given().contentType(ContentType.URLENC)
                .formParam("name", updatedName)
                .formParam("status", updatedStatus)
                .post(baseUrl + "/pet/" + petId);

        return  response;
    }

}

