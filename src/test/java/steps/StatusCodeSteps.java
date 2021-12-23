package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.RestWrapper;

import java.io.File;

public class StatusCodeSteps extends RestWrapper {

    @Step("GET запрос '/dbconnection'. Запрос статус кода")
    public static int getDbConnectionStatusCode() {
        return RestAssured.
                given().spec(API_PATH_DBCONNECTION).log().uri().
                contentType(ContentType.JSON).
                when().get("?login=" + LOGIN + "&password=" + PASSWORD).
                then().log().body().
                extract().statusCode();
    }

    @Step("GET запрос '/forms'. Запрос статус кода")
    public static int getFormsResponseStatusCode() {
         return RestAssured.given().spec(API_PATH_FORMS).log().uri().
                 contentType(ContentType.JSON).
                 header("sessionID", SESSION_ID).
                 when().get().
                 then().extract().statusCode();
    }

    @Step("GET запрос '/form' по id формы. Запрос статус кода")
    public static int getFormByIdResponseStatusCode() {
        return RestAssured.given().spec(API_PATH_FORM).log().uri().
                contentType(ContentType.JSON).
                header("sessionID", SESSION_ID).
                when().get("?formid=" + FORM_ID).
                then().extract().statusCode();
    }

    @Step("GET запрос '/formfilters'. Запрос статус кода")
    public static int getFormFiltersResponseStatusCode() {
        return RestAssured.given().spec(API_PATH_FORM_FILTERS).log().uri().
                contentType(ContentType.JSON).
                header("sessionID", SESSION_ID).
                when().get("?formid=" + FORM_ID).
                then().extract().statusCode();
    }

    @Step("POST запрос '/saveForm'. Запрос статус кода")
    public static int postSaveFormResponseStatusCode() {
        File JSONFormChanges = new File("src/test/resources/jsons/send/JSONFormChanges.json");

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
