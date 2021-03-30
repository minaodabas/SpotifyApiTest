package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;


import java.util.Map;

public class Follow extends RequestSpec {

    public Follow() {
        super("https://api.spotify.com/v1");
    }
    public Response followArtistOrUsers(Map<String,Object> params, ResponseSpecification responseSpecification){

        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParams(params)
                .when()
                .put("/me/following")
                .then()
                .spec(responseSpecification)
                .extract().response();
    }
}
