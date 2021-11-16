package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.PetRequestBody;

import static com.jayway.restassured.RestAssured.given;


public class PetTestSteps {
    
    @Given("create new pet with name \"(.+)\", status \"(.+)\"")
    public void createNewPetWithNameStatus(String name, String status) {
        PetRequestBody petRequestBody = new PetRequestBody();
        petRequestBody.setName(name);
        petRequestBody.setStatus(status);

        String requestBody = null;
        try {
            requestBody = new ObjectMapper().writeValueAsString(petRequestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("accept","application/json")
                .body(requestBody)
                .post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200);
    }

    @When("a client deletes a pet with \"(.+)\" from the system")
    public void aClientDeletesAPetWithFromTheSystem(String name) {
        RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .delete("https://petstore.swagger.io/v2/pet/" + name)
                .then().statusCode(200);
    }

    @Then("verify that pet with \"(.+)\" has been deleted")
    public void verifyThatPetWithHasBeenDeleted(String name) {
            RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .get("https://petstore.swagger.io/v2/user/" + name)
                .then().statusCode(404);
    }



}
