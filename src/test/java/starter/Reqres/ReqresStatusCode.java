package starter.Reqres;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class ReqresStatusCode {

    // Status 200 OK
    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok){
        SerenityRest.then().statusCode(ok);
    }

    // Status 201 Created
    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    // Status 204 No Content
    @Then("Should return {int} No Content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    // Status 400 Bad Request
    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int badRequest){
        SerenityRest.then().statusCode(badRequest);
    }

    // Status 404 Not Found
    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }


}
