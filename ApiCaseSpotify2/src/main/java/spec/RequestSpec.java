package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;
    String baseUrl = "https://api.spotify.com/v1";
    String token = "BQDy7qns5LWBqsccYOb4kfNmZOQ-AonqGWcWQhJWNGOOCSHomUFfr1u5deS2n0sqQ2Rp3OR_GQ30A2yphQfZLGIELYIWZ_iDwzTeiDOtnjmKW_C32blaiuQh7_l7otL1RnekhXda_owGGbIJA5fUxCskrzTCv3OgPlAcnv3tra3AYKYLZPHdnBX7PzDnGbaF9A2ac4SKzaiJWeGyNqgC7omAB6Gn3mjmNZGKHyenLkq97CFYqkXVPcT-fpuLsbsgRwjp0YAaOLBHtS4OkcwySismA2WYqjkrLMuCIQsn";


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
