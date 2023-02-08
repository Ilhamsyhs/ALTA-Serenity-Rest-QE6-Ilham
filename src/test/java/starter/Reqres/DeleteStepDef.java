package starter.Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteStepDef {
    @Steps
    ReqresAPI reqresAPI;


    // Scenario delete user
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    // Scenario delete user with invalid id
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteUserWithInvalidPage(id);
    }


}
