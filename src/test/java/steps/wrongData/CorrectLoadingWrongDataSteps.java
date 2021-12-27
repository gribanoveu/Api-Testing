package steps.wrongData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.RestWrapper;

import java.io.File;

public class CorrectLoadingWrongDataSteps extends RestWrapper {
    public static final String WRONG_LOGIN = "e";
    public static final String WRONG_PASSWORD = "r";
    public static final String GENERATED_WRONG_SESSIONID = "dahjut75yhfnjhuyfgr76ujf";
    public static final String GENERATED_WRONG_FORMID = "999";

    public String getDbConnectionIllegalLoginValidateSchema() {
        return RestAssured.
                given().spec(API_GET_DBCONNECTION).log().uri().
                when().get("?login=" + WRONG_LOGIN + "&password=" + WRONG_PASSWORD).
                then().log().body().
                contentType(ContentType.JSON).
                extract().path("message"); // TODO
    }

    public String getFormsIllegalSessionIdValidateSchema() {
        return RestAssured.
                given().spec(API_GET_FORMS).log().uri().
                header("sessionID", GENERATED_WRONG_SESSIONID).
                when().get().
                then().log().body().
                contentType(ContentType.JSON).
                extract().path("message");
    }

    public String getFormByIllegalIdValidateSchema() {
        return RestAssured.
                given().spec(API_GET_FORM).log().uri().
                header("sessionID", SESSION_ID).
                when().get("?formid=" + GENERATED_WRONG_FORMID).
                then().log().body().
                contentType(ContentType.JSON).
                extract().path("message");
    }

    public String getFormFiltersIllegalFormIdValidateSchema() {
        return RestAssured.
                given().spec(API_GET_FORM_FILTERS).log().uri().
                header("sessionID", SESSION_ID).
                when().get("?formid=" + GENERATED_WRONG_FORMID).
                then().log().body().
                contentType(ContentType.JSON).
                extract().path("message");
    }

    public String  postSaveFormIllegalJsonValidateSchema() {
        File JSONFormChanges = new File("src/test/resources/jsons/send/JSONFormChangesIllegalFilters.json");

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


    public String  getDbConnectionNullInLoginValidateSchema() {
        return RestAssured.
                given().spec(API_GET_DBCONNECTION).log().uri().
                when().get("?login=" + null + "&password=" + null).
                then().log().body().
                contentType(ContentType.JSON).
                extract().path("message"); // TODO
    }
}
