package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;
    String baseUrl = "https://api.spotify.com/v1";
    String token = "BQBi88vlHSDfiy6LjmXxrVoLdUwmTNSIHh8QB_3X8O6YORxr8EG5EQMC7mGbrlHgqZEIuJFWp8hxcVCMU2g_jya28C7Honx20q-gyTMql8LyOFFoivJ5-XRww0kcVUunSQ5o1C3O5Hh4AyMaXm22L1bsv0cFzUbC9mdV9bCTjfU4qqge3ddWl8VuXezZtPKBXE_MSAOziRJEqhp86-Loeh1K5N93_S6kkGsmtDuNgKLPHsozKWoXBeU6a9RWRkb8llYS8JsC3Yhn6r8h7u4l6eY9nDzujLJXau6jeVwQ";


    public RequestSpec(String s) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .setAccept("application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}

