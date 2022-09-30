package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Scenario register success
    @Given("Post register success")
    public void postRegisterSuccess() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Register/PostRegisterSuccess.json");
        reqresAPI.postRegisterSuccess(json);
    }

    @When("Send request post register success")
    public void sendRequestPostRegisterSuccess() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESS);
    }

    @And("Post register success json schema validator")
    public void postRegisterSuccessJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostRegisterSuccessJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario register without email
    @Given("Post Register without email")
    public void postRegisterWithoutEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Register/PostRegisterWithoutEmail.json");
        reqresAPI.postRegisterFailed(json);
    }

    @When("Send request post register without email")
    public void sendRequestPostRegisterWithoutEmail() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_FAILED);
    }

    @And("Post register without email json schema validator")
    public void postRegisterWithoutEmailJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostRegisterWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario register without password
    @Given("Post Register without password")
    public void postRegisterWithoutPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Register/PostRegisterWithoutPassword.json");
        reqresAPI.postRegisterFailed(json);
    }

    @When("Send request post register without password")
    public void sendRequestPostRegisterWithoutPassword() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_FAILED);
    }

    @And("Post register without password json schema validator")
    public void postRegisterWithoutPasswordJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostRegisterWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
