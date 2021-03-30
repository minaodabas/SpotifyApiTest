package service;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;


public class PlayLists extends RequestSpec {


    public PlayLists() {
        super(	"https://api.spotify.com/v1");
    }
    public Response createPlayList(String id,ResponseSpecification responseSpecification){
        String body = "{\n" +
                "  \"name\": \"New Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";
       return RestAssured.given()
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .post("/users/{user_id}/playlists",id)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }


    public Response getPlayListOfUser(String userId,ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .when()
                .get("users/{user_id}/playlists",userId)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }

    public Response getPlayListById(String playListId,ResponseSpecification responseSpecification){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParam("market","TR")
                .when()
                .get("/playlists/{playlist_id}/tracks",playListId)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }

    public Response addATrack(String uri, String playListId,ResponseSpecification responseSpecification){
        return  RestAssured.given()
                    .spec(getRequestSpecification())
                    .queryParam("uris",uri)
                    .when()
                    .post("/playlists/{playlist_id}/tracks",playListId)
                    .then()
                    .spec(responseSpecification)
                    .extract().response();
    }


}
