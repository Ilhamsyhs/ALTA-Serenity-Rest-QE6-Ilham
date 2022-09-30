package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Scenario get single user with id
    @Given("Get single user with parameter id {int}")
    public void getSingleUserWithParameterIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body should contain firstname {string} and lastname {string}")
    public void responseBodyShouldContainFirstnameAndLastname(String first, String last) {
        SerenityRest.then()
                .body(ReqresResponses.FNAME, equalTo(first))
                .body(ReqresResponses.LNAME, equalTo(last));
    }

    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/GetSingleUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario get single user invalid id
    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidIdId(String id) {
        reqresAPI.getSingleUserInvalidId(id);
    }

    @When("Send request get single user with invalid id")
    public void sendRequestGetSingleUserWithInvalidId() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }



    // Scenario get single user not found
    @Given("Get single user not found with id {int}")
    public void getSingleUserNotFoundWithIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user not found")
    public void sendRequestGetSingleUserNotFound() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }


}
