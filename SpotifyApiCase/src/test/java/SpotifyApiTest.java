import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import spec.ResponseSpec;

import java.util.List;

public class SpotifyApiTest extends BaseClass{


    @Test
    public void TestCase(){

        Response response = search.searchAnArtist(ResponseSpec.checkStatusCodeOk());
        List<String> list = ((RestAssuredResponseImpl) response).response().path("artists.items.id");
        String id =list.get(0);
        System.out.println(id);


        Response topTrackResponse = artist.getAnArtistTopTrack(id, ResponseSpec.checkStatusCodeOk());
        List<String> list2 = ((RestAssuredResponseImpl) topTrackResponse).response().path("tracks.album.id");
        String trackId = list2.get(0);
        System.out.println(trackId);




    }
}
