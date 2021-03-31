package services;
import com.google.common.io.Resources;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.json.JSONObject;
import spec.RequestSpec;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class PlayList extends RequestSpec {

    public PlayList() { super("https://api.spotify.com/v1"); }

    public Response createAPlayList(String userId){
        String body = "{\n" +
                "  \"name\": \"New Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .body(body)
                .when()
                .post("/users/{user_id}/playlists",userId)
                .then()
                .statusCode(201)
                .extract().response();

    }

    public boolean checkPlayListIsNull(String playListId){
        Response response = RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParam("market","TR")
                .when()
                .get("/playlists/{playlist_id}/tracks",playListId)
                .then()
                .statusCode(200)
                .extract().response();
        List<Object> list = response.jsonPath().getList("items");
        System.out.println(list.size());
        if (list.size() != 0) return false;
        return true;
    }

    public void addATrack(List<String> uri, String playListId){
        //neden for kullandık
        for(String track : uri ) {
            RestAssured.given()
                    .spec(super.getRequestSpecification())
                    .queryParam("uris", track)
                    .when()
                    .post("/playlists/{playlist_id}/tracks", playListId)
                    .then()
                    .statusCode(201)
                    .extract().response();
        }
    }


    public void deleteATrack(String trackUri,String playListId) throws IOException {
        URL file = Resources.getResource("deleteBody.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject deleteBody = new JSONObject(myJson);
        deleteBody.getJSONArray("tracks").getJSONObject(0).put("uri",trackUri);

        RestAssured.given()
                .spec(super.getRequestSpecification())
                .body(deleteBody.toString())
                .when()
                .delete("/playlists/{playlist_id}/tracks", playListId)
                .then()
                .statusCode(200)
                .extract().response();
    }

    public Response getPlayListItem(String playListId){
        return RestAssured.given()
                .spec(super.getRequestSpecification())
                .queryParam("market", "TR")
                .queryParam("playlist_id", playListId)
                .when()
                .get("/playlists/{playlist_id}/tracks",playListId)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}
