package steps.validData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.RestWrapper;
import util.StringUtils;

import java.io.File;

public class StatusCodeValidDataSteps extends RestWrapper {
    private static final String GENERATED_SESSIONID = StringUtils.getRandomString(24);
    private static final String GENERATED_LOGIN_DATA = StringUtils.getRandomString(5);
    private static final int GENERATED_FORMID = StringUtils.getRandomNumberAsString(90, 99);

    public int dbConnectionGeneratedLoginData() {
        return RestAssured.
                given().spec(API_GET_DBCONNECTION).log().uri().
                contentType(ContentType.JSON).
                when().get("?login=" + GENERATED_LOGIN_DATA + "&password=" + GENERATED_LOGIN_DATA).
                then().log().body().
                extract().statusCode();
    }

    public int getFormsGeneratedSessionId() {
        return RestAssured.given().spec(API_GET_FORMS).log().uri().
                contentType(ContentType.JSON).
                header("sessionID", GENERATED_SESSIONID).
                when().get().
                then().extract().statusCode();
    }

    public int getFormByGeneratedId() {
        return RestAssured.given().spec(API_GET_FORM).log().uri().
                contentType(ContentType.JSON).
                header("sessionID", SESSION_ID).
                when().get("?formid=" + GENERATED_FORMID).
                then().extract().statusCode();
    }

   public int getFormFiltersByGeneratedId() {
       return RestAssured.given().spec(API_GET_FORM_FILTERS).log().uri().
               contentType(ContentType.JSON).
               header("sessionID", SESSION_ID).
               when().get("?formid=" + GENERATED_FORMID).
               then().extract().statusCode();
   }

    public int postSaveFormWrongJson() {
        File JSONFormChanges = new File("src/test/resources/jsons/send/JSONFormChangesWrongFilters.json");

        RequestSpecification request = RestAssured.given().
                contentType(ContentType.JSON).
                spec(API_POST_SAVE_FORM).log().uri().
                header("Content-Type", "application/json").
                header("sessionID", SESSION_ID).
                body(JSONFormChanges).log().body();

        return request.when().post("?formid=" + FORM_ID).
                then().statusCode(200).
                extract().statusCode();
    }
}
