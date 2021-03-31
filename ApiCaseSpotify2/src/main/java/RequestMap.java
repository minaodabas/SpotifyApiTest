import java.util.HashMap;
import java.util.Map;

public class RequestMap {

    public Map<String,Object> searchParams(String trackName, String type , String market , int limit){
        Map<String,Object> params = new HashMap<>();
        params.put("q",trackName);
        params.put("type",type);
        params.put("market",market);
        params.put("limit",limit);

        return params;
    }
}
