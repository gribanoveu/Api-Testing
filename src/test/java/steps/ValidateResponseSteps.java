package steps;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import models.SessionIdPojo;
import org.hamcrest.Matcher;
import util.RestWrapper;

import java.util.Collection;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class ValidateResponseSteps extends RestWrapper {
    private static final String SESSION_ID = DbConnectionSteps.getDbConnectionAndGetSessionId();
    private static final String FORM_ID = "1";
    private static final RequestSpecification API_PATH = getReqSpec("/dbconnection");
    private static final RequestSpecification API_PATH_FORMS = getReqSpec("/forms");
    private static final RequestSpecification API_PATH_DBCONNECTION = getReqSpec("/dbconnection");
    private static final RequestSpecification API_PATH_FORM = getReqSpec("/form");
    private static final RequestSpecification API_PATH_FORM_FILTERS = getReqSpec("/formfilters");
    private static final RequestSpecification API_PATH_SAVE_FORM = getReqSpec("/saveForm");

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

    public static void getDbConnectionValidateSchema() {
        RestAssured.given().
                spec(API_PATH_DBCONNECTION).log().uri().
                when().get("?login=" + LOGIN + "&password=" + PASSWORD).
                then().log().status().
                assertThat().body(matchesJsonSchemaInClasspath("jsons/schemas/AUTH_SHEMA.json"));
    }

    public static void getFormsValidateSchema(List<String> names) {
         RestAssured.given().
                 spec(API_PATH_FORMS).log().uri().
                 header("sessionID", SESSION_ID).
                 when().get("?formid=" + FORM_ID).
                 then().log().status().
                 spec(new ResponseSpecBuilder().
                         expectStatusCode(200).
                         expectBody("root.folders.name", equalTo(names)).
                         build());
         log.info("GET запрос /forms содержит следующие поля names: " + names.toString());
    }

}
