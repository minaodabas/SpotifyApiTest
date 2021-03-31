package services;

import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import spec.RequestSpec;

import java.util.List;
import java.util.Map;

public class Search extends RequestSpec {
    public Search() { super("https://api.spotify.com/v1"); }

    public String searchATrack(Map<String,Object> params){
        Response trackResponse = RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParams(params)
                .when()
                .get("/search")
                .then()
                .statusCode(200)
                .extract().response();
        List<String> uri = ((RestAssuredResponseImpl) trackResponse).response().path("tracks.items.uri");

        String trackUri = uri.get(0);
        System.out.println(uri);
        return trackUri;
    }
}
