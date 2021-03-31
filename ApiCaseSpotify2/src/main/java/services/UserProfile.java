package services;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import spec.RequestSpec;

public class UserProfile extends RequestSpec {
    public UserProfile() {super("https://api.spotify.com/v1");}

    public Response getUserId(){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .when()
                .get("/me")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
