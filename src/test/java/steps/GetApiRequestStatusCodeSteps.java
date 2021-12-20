package steps;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class GetApiRequestStatusCodeSteps extends BaseSteps {
    private static final String SESSION_ID = DbConnectionSteps.getDbConnectionAndGetSessionId();
    private static final RequestSpecification API_PATH = getReqSpec("/form");

    public static int getFormResponseStatusCode() {
         return RestAssured.given().spec(API_PATH).log().uri().
                header("sessionID", SESSION_ID).
                when().get().
                then().extract().statusCode();
    }
    public static int getDbConnectionStatusCode() {
        return RestAssured.
                given().spec(API_PATH).
                when().get("?login=" + LOGIN + "&password=" + PASSWORD).
                then().extract().statusCode();
    }
}
