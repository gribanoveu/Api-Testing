package steps;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class FormResponseSteps extends BaseSteps {
    private static final String SESSION_ID = DbConnectionSteps.getDbConnectionAndGetSessionId();
    private static RequestSpecification API_PATH = getReqSpec("/form");

    public static int getFormResponseStatusCode() {
         return RestAssured.given().spec(API_PATH).log().uri().
                header("sessionID", SESSION_ID).
                when().get().
                then().extract().statusCode();
    }
}
