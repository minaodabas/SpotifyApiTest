package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;

public class Artist extends RequestSpec {
    public Artist() { super("https://api.spotify.com/v1");}



    public Response getAnArtistTopTrack(String id,ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParam("id",id)
                .queryParam("market","TR")
                .when()
                .get("/artists/{id}/top-tracks",id)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }
}
