package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;

    String token = "BQChmNGV-HqziWdLPFguIwJdDX9vKKXHTX0VTx6V70KMp_c4R-XxCTzGi0S-rIkRUxMKuhxYtN1VSqCsUiycsCkCv0y5rTFlEItSg0OwTIXqxba2KKQhIG9iofH2gL-zOhNwKtCGQsDwZNfUDZ3ykEhIjwXIII7F9R5pWgOgN_jn4UjFxzzdkwaDkMYcmiZcmwAYU-t_7DXbkWuKb1m1TD7DsiHD6CX6MxVAyoLSxndE7oXRCWVrDFy3jFQr2vyy9ystU-3y1cUPGTFwWOGuwctnCuGr71ZvVXW-c6wJ";


    public RequestSpec(String baseUrl) {
         requestSpecification = new RequestSpecBuilder()
                 .setBaseUri(baseUrl)
                 .setContentType("application/json")
                 .setAccept("application/json")
                 .addHeader("Authorization", "Bearer " + token)
                 .build();
    }

    public RequestSpecification getRequestSpecification() {return requestSpecification;}
}
