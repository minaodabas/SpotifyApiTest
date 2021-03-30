package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class User extends RequestSpec {

    public User() {
        super("https://api.spotify.com/v1");
    }

    public Response getUserResponse(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(getRequestSpecification())
                .when()
                .get("/me")
                .then()
                .spec(responseSpecification)
                .extract().response();



    }
}
