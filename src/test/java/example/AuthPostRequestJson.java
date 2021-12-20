package example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class AuthPostRequestJson {
    private static final String URL = "https://fakestoreapi.com/auth/";
    private static final String USERNAME = "mor_2314";
    private static final String PASSWORD = "83r5^_";

    public static String getTokenAfterLogin() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", USERNAME);
        requestBody.put("password", PASSWORD);

        RequestSpecification request = RestAssured.given().log().uri().
                header("Content-Type", "application/json").
                body(requestBody.toString());

        return request.when().post(URL + "login").
                then().statusCode(200).
                extract().path("token");
    }
}
