package steps.validData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.RestWrapper;

import java.io.File;

public class CorrectLoadingValidDataSteps extends RestWrapper {
    public static final String VALID_LOGIN = "e";
    public static final String VALID_PASSWORD = "r";
    public static final String GENERATED_VALID_SESSIONID = "dahjut75yhfnjhuyfgr76ujf";
    public static final String GENERATED_VALID_FORMID = "999";


    public String getDbConnectionValidSessionIdValidateSchema() {
        return RestAssured.
                given().spec(API_GET_DBCONNECTION).log().uri().
                when().get("?login=" + VALID_LOGIN + "&password=" + VALID_PASSWORD).
                then().log().body().
                    contentType(ContentType.JSON).
                    extract().path("message"); // TODO
    }

    public String getFormsValidSessionIdValidateSchema() {
       return RestAssured.
                given().spec(API_GET_FORMS).log().uri().
                    header("sessionID", GENERATED_VALID_SESSIONID).
                when().get().
                then().log().body().
                    contentType(ContentType.JSON).
                    extract().path("message"); // TODO
    }

    public String getFormByValidIdValidateSchema() {
        return RestAssured.
                given().spec(API_GET_FORM).log().uri().
                    header("sessionID", SESSION_ID).
                when().get("?formid=" + GENERATED_VALID_FORMID).
                then().log().body().
                    contentType(ContentType.JSON).
                    extract().path("message");
    }

    public String getFormFiltersValidFormIdValidateSchema() {
        return RestAssured.
                given().spec(API_GET_FORM_FILTERS).log().uri().
                    header("sessionID", SESSION_ID).
                when().get("?formid=" + GENERATED_VALID_FORMID).
                then().log().body().
                    contentType(ContentType.JSON).
                    extract().path("message");
    }

    public String postSaveFormValidJsonValidateSchema() {
        File JSONFormChanges = new File("src/test/resources/jsons/send/JSONFormChangesWrongFilters.json");

        RequestSpecification request = RestAssured.given().
                contentType(ContentType.JSON).
                spec(API_POST_SAVE_FORM).log().uri().
                header("Content-Type", "application/json").
                header("sessionID", SESSION_ID).
                body(JSONFormChanges).log().body();

        return request.when().post("?formid=" + FORM_ID).
                then().log().body().
                contentType(ContentType.JSON).
                extract().path("message");
    }
}
