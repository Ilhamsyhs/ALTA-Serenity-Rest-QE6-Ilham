package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginFailedStepDef {
    @Steps
    ReqresAPI reqresAPI;


    // Scenario login failed
    @Given("Post login unsuccess")
    public void postLoginUnsuccess() {
        File json = new File(ReqresAPI.JSON_FILE+"/Non/Login/PostLoginFailed.json");
        reqresAPI.loginSuccess(json);
    }

    @When("Send request post login unsuccess")
    public void sendRequestPostLoginUnsuccess() {
        SerenityRest.when().post(ReqresAPI.LOGIN_FAILED);
    }

    @And("Response body should show message {string}")
    public void responseBodyShouldShowMessage(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR, equalTo(error));
    }


}
