import services.PlayList;
import services.Search;
import services.UserProfile;

public class BaseClass {
    UserProfile user = new UserProfile();
    PlayList playList = new PlayList();
    Search search = new Search();
    RequestMap requestMap = new RequestMap();
}
