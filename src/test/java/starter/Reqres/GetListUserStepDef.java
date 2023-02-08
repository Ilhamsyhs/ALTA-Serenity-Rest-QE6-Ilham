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

public class GetListUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Scenario get user from page
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Get list user json schema validator")
    public void getListUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/GetListUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario get user with invalid page
    @Given("Get list user with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPage(String page) {
        reqresAPI.getListUserInvalid(page);
    }


    // Scenario get user exceed parameter
    @Given("Get list user with exceed parameter page {int}")
    public void getListUserWithExceedParameterPagePage(int page) {
        reqresAPI.getListUser(page);
    }


}
