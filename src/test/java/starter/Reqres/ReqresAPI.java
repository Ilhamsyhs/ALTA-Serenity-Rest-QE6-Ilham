package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;



import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JSON";


    public static String GET_LIST_USER = URL + "/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL + "/api/users";
    public static String POST_CREATE_NEW_USER_INVALID = URL + "/api/users";
    public static String POST_REGISTER_SUCCESS = URL + "/api/register";
    public static String POST_REGISTER_FAILED = URL + "/api/register";
    public static String PUT_UPDATE_USER = URL + "/api/users/{id}";
    public static String PUT_UPDATE_USER_WITHOUT_PATH = URL + "/api/users";
    public static String DELETE_USER = URL + "/api/users/{id}";
    public static String LOGIN_SUCCESS = URL + "/api/login";
    public static String LOGIN_FAILED = URL + "/api/login";
    public static String LOGIN_INVALID = URL + "/api/login";
    public static String GET_SINGLE_USER = URL + "/api/users/{id}";

    @Step("Get list user")
    public void getListUser(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get list user invalid parameter")
    public void getListUserInvalid(String page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user invalid id")
    public void getSingleUserInvalidId(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create new user invalid")
    public void postCreateNewUserInvalid(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register success")
    public void postRegisterSuccess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register failed")
    public void postRegisterFailed(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user invalid")
    public void putUpdateUserInvalid(String id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

//    @Step("Put update user without path")
//    public void putUpdateUserWithoutPath(File json){
//        SerenityRest.given()
//                .contentType(ContentType.JSON)
//                .body(json);
//    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user with invalid page")
    public void deleteUserWithInvalidPage(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Login success")
    public void loginSuccess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Login with invalid parameter")
    public void loginInvalidParameter(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
