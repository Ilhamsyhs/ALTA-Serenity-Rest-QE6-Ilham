package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;


    // Scenario update user
    @Given("Put update user with id {int}")
    public void putUpdateUserWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Update/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Put update user json schema validator")
    public void putUpdateUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PutUpdateUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario update user with invalid id
    @Given("Put update user with id {string}")
    public void putUpdateUserWithId(String id) {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Update/PutUpdateUser.json");
        reqresAPI.putUpdateUserInvalid(id, json);
    }



    // Scenario update user without field name
    @Given("Put update user without field name on id {int}")
    public void putUpdateUserWithoutFieldNameOnIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Update/PutUpdateUserWithoutFieldName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user without field name")
    public void sendRequestPutUpdateUserWithoutFieldName() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }



    // Scenario update user without field name
    @Given("Put update user without field job on id {int}")
    public void putUpdateUserWithoutFieldJobOnIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Update/PutUpdateUserWithoutFieldJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user without field job")
    public void sendRequestPutUpdateUserWithoutFieldJob() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }



    // Scenario update user with empty name
    @Given("Put update user with empty name on id {int}")
    public void putUpdateUserWithEmptyNameOnIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Update/PutUpdateUserWithEmptyName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user with empty name")
    public void sendRequestPutUpdateUserWithEmptyName() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }



    // Scenario update user with empty job
    @Given("Put update user with empty job on id {int}")
    public void putUpdateUserWithEmptyJobOnIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Update/PutUpdateUserWithEmptyJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user with empty job")
    public void sendRequestPutUpdateUserWithEmptyJob() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }


}
