package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class Search extends RequestSpec {
    public Search() { super("https://api.spotify.com/v1");}

    public Response searchAnArtist(ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParam("q", "murda")
                .queryParam("type" , "artist")
                .when()
                .get("/search")
                .then()
                .spec(responseSpecification)
                .extract().response();
    }


}
