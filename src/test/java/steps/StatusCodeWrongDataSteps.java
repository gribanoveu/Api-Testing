package steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.RestWrapper;
import util.StringUtils;

import java.io.File;

public class StatusCodeWrongDataSteps extends RestWrapper {
    private static final String GENERATED_WRONG_SESSIONID = StringUtils.getRandomIllegalCharactersString(24);
    private static final String GENERATED_WRONG_LOGIN_DATA = StringUtils.getRandomIllegalCharactersString(5);
    private static final String GENERATED_WRONG_FORMID = StringUtils.getRandomIllegalCharactersString(2);

    public int dbConnectionIllegalLoginData() {
        return RestAssured.
                given().spec(API_PATH_DBCONNECTION).log().uri().
                contentType(ContentType.JSON).
                when().get("?login=" + GENERATED_WRONG_LOGIN_DATA + "&password=" + GENERATED_WRONG_LOGIN_DATA).
                then().log().body().
                extract().statusCode();
    }

    public int getFormsIllegalSessionId() {
        return RestAssured.given().spec(API_PATH_FORMS).log().uri().
                contentType(ContentType.JSON).
                header("sessionID", GENERATED_WRONG_SESSIONID).
                when().get().
                then().extract().statusCode();
    }

    public int getFormByIllegalId() {
        return RestAssured.given().spec(API_PATH_FORM).log().uri().
                contentType(ContentType.JSON).
                header("sessionID", SESSION_ID).
                when().get("?formid=" + GENERATED_WRONG_FORMID).
                then().extract().statusCode();
    }

    public int getFormFiltersByIllegalId() {
        return RestAssured.given().spec(API_PATH_FORM_FILTERS).log().uri().
                contentType(ContentType.JSON).
                header("sessionID", SESSION_ID).
                when().get("?formid=" + GENERATED_WRONG_FORMID).
                then().extract().statusCode();
    }

    public int postSaveFormIllegalJson() {
        File JSONFormChanges = new File("src/test/resources/jsons/send/JSONFormChangesIllegalFilters.json");

        RequestSpecification request = RestAssured.given().
                contentType(ContentType.JSON).
                spec(API_PATH_SAVE_FORM).log().uri().
                header("Content-Type", "application/json").
                header("sessionID", SESSION_ID).
                body(JSONFormChanges).log().body();

        return request.when().post("?formid=" + FORM_ID).
                then().statusCode(200).
                extract().statusCode();
    }
}
