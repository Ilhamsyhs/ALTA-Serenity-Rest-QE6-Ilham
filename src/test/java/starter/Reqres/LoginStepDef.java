package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;


    // Scenario login success
    @Given("Post login success")
    public void postLoginSuccess() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Login/PostLoginSuccess.json");
        reqresAPI.loginSuccess(json);
    }

    @When("Send request post login success")
    public void sendRequestPostLoginSuccess() {
        SerenityRest.when().post(ReqresAPI.LOGIN_SUCCESS);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Post login success json schema validator")
    public void postLoginSuccessJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostLoginSuccessJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario login with invalid email
    @Given("Post login invalid email")
    public void postLoginInvalidEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Login/PostLoginInvalidEmail.json");
        reqresAPI.loginInvalidParameter(json);
    }

    @When("Send request post login invalid email")
    public void sendRequestPostLoginInvalidEmail() {
        SerenityRest.when().post(ReqresAPI.LOGIN_INVALID);
    }

    @And("Post login invalid email json schema validator")
    public void postLoginInvalidEmailJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostLoginWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scneario login with empty email
    @Given("Post login empty email")
    public void postLoginEmptyEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Login/PostLoginEmptyEmail.json");
        reqresAPI.loginInvalidParameter(json);
    }

    @When("Send request post login empty email")
    public void sendRequestPostLoginEmptyEmail() {
        SerenityRest.when().post(ReqresAPI.LOGIN_INVALID);
    }

    @And("Post login empty email json schema validator")
    public void postLoginEmptyEmailJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostLoginWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario login with empty password
    @Given("Post login empty password")
    public void postLoginEmptyPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Login/PostLoginEmptyPassword.json");
        reqresAPI.loginInvalidParameter(json);
    }

    @When("Send request post login empty password")
    public void sendRequestPostLoginEmptyPassword() {
        SerenityRest.when().post(ReqresAPI.LOGIN_INVALID);
    }

    @And("Post login empty password json schema validator")
    public void postLoginEmptyPasswordJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/Validator/PostLoginWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // Scenario login with invalid password
    @Given("Post login invalid password")
    public void postLoginInvalidPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Login/PostLoginInvalidPassword.json");
        reqresAPI.loginInvalidParameter(json);
    }

    @When("Send request post login invalid password")
    public void sendRequestPostLoginInvalidPassword() {
        SerenityRest.when().post(ReqresAPI.LOGIN_INVALID);
    }


}
