package steps.positive;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import util.RestWrapper;

public class ResponseTimeOutSteps extends RestWrapper {

    public long getDbConnectionTimeout() {
        return RestAssured.
                given().spec(API_GET_DBCONNECTION).log().uri().
                contentType(ContentType.JSON).
                when().get("?login=" + LOGIN + "&password=" + PASSWORD).
                then().log().body().
                extract().response().time();
    }
}
