package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetApiRequestStatusCodeSteps extends BaseSteps {
    private static final String SESSION_ID = DbConnectionSteps.getDbConnectionAndGetSessionId();
    private static final String FORM_ID = "1";

    private static final RequestSpecification API_PATH_FORMS = getReqSpec("/forms");
    private static final RequestSpecification API_PATH_DBCONNECTION = getReqSpec("/dbconnection");
    private static final RequestSpecification API_PATH_FORM = getReqSpec("/form");
    private static final RequestSpecification API_PATH_FORM_FILTERS = getReqSpec("/formfilters");
    private static final RequestSpecification API_PATH_SAVE_FORM = getReqSpec("/saveForm");

    @Step("GET запрос '/dbconnection'. Запрос статус кода")
    public static int getDbConnectionStatusCode() {
        return RestAssured.
                given().spec(API_PATH_DBCONNECTION).
                when().get("?login=" + LOGIN + "&password=" + PASSWORD).
                then().extract().statusCode();
    }

    @Step("GET запрос '/forms'. Запрос статус кода")
    public static int getFormsResponseStatusCode() {
         return RestAssured.given().spec(API_PATH_FORMS).log().uri().
                header("sessionID", SESSION_ID).
                when().get().
                then().extract().statusCode();
    }

    @Step("GET запрос '/form' по id формы. Запрос статус кода")
    public static int getFormByIdResponseStatusCode() {
        return RestAssured.given().spec(API_PATH_FORM).log().uri().
                header("sessionID", SESSION_ID).
                when().get("?formid=" + FORM_ID).
                then().extract().statusCode();
    }

    @Step("GET запрос '/formfilters'. Запрос статус кода")
    public static int getFormFiltersResponseStatusCode() {
        return RestAssured.given().spec(API_PATH_FORM_FILTERS).log().uri().
                header("sessionID", SESSION_ID).
                when().get("?formid=" + FORM_ID).
                then().extract().statusCode();
    }

    @Step("POST запрос '/saveForm'. Запрос статус кода")
    public static int postSaveFormResponseStatusCode() {
        JSONArray jsonArray = new JSONArray();

        // TODO: Нужен передаваемый JSON обьект JSONFormChanges

        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "USERNAME");
        requestBody.put("password", "PASSWORD");

        RequestSpecification request = RestAssured.given().spec(API_PATH_SAVE_FORM).log().uri().
                header("Content-Type", "application/json").
                header("sessionID", SESSION_ID).
                body(requestBody.toString());

        return request.when().post("?formid=" + FORM_ID).
                then().statusCode(200).
                extract().statusCode();
    }
}
