package steps;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import models.SessionIdPojo;
import util.RestWrapper;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ValidateSchemaSteps extends RestWrapper {
    private static final RequestSpecification API_PATH = getReqSpec("/dbconnection");

    public static void dbConnectionReturnSessionId() {
        SessionIdPojo sessionId = RestAssured.
                given().spec(API_PATH).
                when().get("?login=" + LOGIN + "&password=" + PASSWORD).
                then().statusCode(200).
                extract().body().as(SessionIdPojo.class);

        int sessionIdLength = sessionId.getSessionID().length();
        assertThat(sessionId.getSessionID()).isNotEmpty();
        log.info("Длина токена составляет: " + sessionIdLength + " символов");
    }
}
