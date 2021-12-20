package steps;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DbConnectionSteps extends BaseSteps {
    private static final RequestSpecification API_PATH = getReqSpec("/dbconnection");

    public static String getDbConnectionAndGetSessionId() {
        return RestAssured.given().spec(API_PATH).
                when().
                    get("?login=" + LOGIN + "&password=" + PASSWORD)
                .then().
                    statusCode(200).
                    extract().path("sessionID");
    }

}
