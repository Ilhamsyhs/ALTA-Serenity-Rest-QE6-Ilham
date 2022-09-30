package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateNewUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Scenario add new user
    @Given("Post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/CreateNewUser/PostCreateNewUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Post create new user json schema validator")
    public void postCreateNewUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostCreateNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario add new user without field name
    @Given("Post create new user without field name")
    public void postCreateNewUserWithoutFieldName() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/CreateNewUser/PostCreateNewUserWithoutFieldName.json");
        reqresAPI.postCreateNewUserInvalid(json);
    }

    @When("Send request post create new user without field name")
    public void sendRequestPostCreateNewUserWithoutFieldName() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }



    // Scenario add new user without field job
    @Given("Post create new user without field job")
    public void postCreateNewUserWithoutFieldJob() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/CreateNewUser/PostCreateNewUserWithoutFieldJob.json");
        reqresAPI.postCreateNewUserInvalid(json);
    }

    @When("Send request post create new user without field job")
    public void sendRequestPostCreateNewUserWithoutFieldJob() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }



    // Scenario add new user with empty name
    @Given("Post create new user with empty name")
    public void postCreateNewUserWithEmptyName() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/CreateNewUser/PostCreateNewUserWithEmptyName.json");
        reqresAPI.postCreateNewUserInvalid(json);
    }

    @When("Send request post create new user with empty name")
    public void sendRequestPostCreateNewUserWithEmptyName() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }



    // Scenario add new user with empty job
    @Given("Post create new user with empty job")
    public void postCreateNewUserWithEmptyJob() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/CreateNewUser/PostCreateNewUserWithEmptyJob.json");
        reqresAPI.postCreateNewUserInvalid(json);
    }

    @When("Send request post create new user with empty job")
    public void sendRequestPostCreateNewUserWithEmptyJob() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }

}
