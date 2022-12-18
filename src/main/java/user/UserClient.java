package user;
import client.Client;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    private final String LOGIN_USER = "/api/auth/login";
    private final String DELETE_USER = "/api/auth/user";
    private final String CREATE_USER = "/api/auth/register";

    @Step("login user")
    public Response loginUser(Object object) {
        return given()
                .spec(getSpec())
                .body(object)
                .when()
                .post(LOGIN_USER);
    }

    @Step("delete user")
    public void delete(String accessToken) {
        if (accessToken == null) {
            return;
        }
        given()
                .header("Authorization", accessToken)
                .spec(getSpec())
                .when()
                .delete(DELETE_USER)
                .then()
                .statusCode(202);
    }

    @Step(" create user")
    public Response createUser(Object object) {
        return given()
                .spec(getSpec())
                .body(object)
                .when()
                .post(CREATE_USER);
    }
}