package steps;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.json.JSONObject;
import util.ProjectProperties;

public class Auth {
    private static ProjectProperties getProjectProperties() {
        return ConfigFactory.newInstance().create(ProjectProperties.class, System.getProperties());
    }

    private static final String URL = getProjectProperties().apiUrl();
    private static final String USERNAME = getProjectProperties().userName();
    private static final String PASSWORD = getProjectProperties().userPassword();

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
