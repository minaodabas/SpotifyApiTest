import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BaseTest extends BaseClass{
/**
 * yeni playlist oluştur +
 * bu playlistin boş olduğunu kontrol et+
 * bu play liste 3 sarki ekle+
 * bu playlist bos olmadıgını dogrula
 * bu playlistin en son ekledigin sarkiyi sil
 * silindigini kontrol et
 */
  @Test
    public void TestCase() throws IOException {

     Response userResponse = user.getUserId();
     String userId = userResponse.getBody().jsonPath().getString("id");
     System.out.println(userId);

     playList.createAPlayList(userId);
     Response playListResponse = playList.createAPlayList(userId);
     String playListId = playListResponse.getBody().jsonPath().getString("id");
     System.out.println(playListId);

      assertTrue(playList.checkPlayListIsNull(playListId));

      Map<String,Object> params = requestMap.searchParams("beat it","track","TR",1);
      Map<String,Object> params1 = requestMap.searchParams("partition","track","TR",1);
      Map<String,Object> params2 = requestMap.searchParams("diamonds","track","TR",1);




      List<String> trackList = new ArrayList<>();
      String track1 = search.searchATrack(params);
      trackList.add(track1);
      String track2 = search.searchATrack(params1);
      trackList.add(track2);
      String track3 = search.searchATrack(params2);
      trackList.add(track3);

     playList.addATrack(trackList,playListId);

     assertFalse(playList.checkPlayListIsNull(playListId));

     String uri = trackList.get(2);

     playList.deleteATrack(uri,playListId);
     System.out.println(uri);

     Response response = playList.getPlayListItem(playListId);

   Boolean isContain = response.getBody().jsonPath().getString("items").contains(uri);
   System.out.println(isContain);
   assertFalse(isContain);






  }


}
