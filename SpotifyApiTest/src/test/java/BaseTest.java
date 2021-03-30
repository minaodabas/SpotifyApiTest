import io.restassured.response.Response;
import org.testng.annotations.Test;
import spec.ResponseSpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseTest extends BaseClass{


    @Test
    public void testCase(){
        String userId = "9b708xxrb5v9fdpgoqh8hx88i";


        Response userResponse = user.getUserResponse(ResponseSpec.checkStatusCodeOk());
        String myUserId = userResponse.getBody().jsonPath().getString("id");
        //System.out.println(userId);

        Response playListResponse = playLists.createPlayList(myUserId,ResponseSpec.checkStatusCodeCreated());
        String myPlayListId = playListResponse.getBody().jsonPath().getString("id");
        //System.out.println(myPlayListId);
        //List<Object> trackList = playListResponse.jsonPath().getList("items");
        //System.out.println(trackList.size());


        Response playListOfUserResponse = playLists.getPlayListOfUser(userId,ResponseSpec.checkStatusCodeOk());
        List<Map> list = playListOfUserResponse.jsonPath().getList("items");
        String playListId = list.get(0).get("id").toString();


        Response playListByIdResponse = playLists.getPlayListById(playListId,ResponseSpec.checkStatusCodeOk());
        List<Map> playList = playListByIdResponse.jsonPath().getList("items");

        for(int i = 0 ; i<3 ; i++){
            Map<String,Object> track = (Map<String, Object>) playList.get(i).get("track");
            //System.out.println(track.get("uri").toString());
            playLists.addATrack(track.get("uri").toString(),myPlayListId,ResponseSpec.checkStatusCodeCreated());

        }

        Response myPlayListOfUserResponse = playLists.getPlayListOfUser(myUserId,ResponseSpec.checkStatusCodeOk());
        myPlayListOfUserResponse.prettyPeek();



    }

    @Test
    public void followTest(){
        String id = "9b708xxrb5v9fdpgoqh8hx88i";
        Map<String,Object> params = new HashMap<>();
        params.put("type","user");
        params.put("ids",id);

        follow.followArtistOrUsers(params, ResponseSpec.checkStatusCodeOk());
    }

}
