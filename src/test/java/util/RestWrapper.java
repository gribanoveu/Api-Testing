package util;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

public abstract class RestWrapper {
    protected static final String API_URL = getProjectProperties().apiUrl();
    protected static final String LOGIN = getProjectProperties().apiLogin();
    protected static final String PASSWORD = getProjectProperties().apiPassword();
    protected static final String FORM_ID = getProjectProperties().formId();

    protected static final RequestSpecification API_PATH = getReqSpec("/dbconnection");
    protected static final RequestSpecification API_PATH_FORMS = getReqSpec("/forms");
    protected static final RequestSpecification API_PATH_DBCONNECTION = getReqSpec("/dbconnection");
    protected static final RequestSpecification API_PATH_FORM = getReqSpec("/form");
    protected static final RequestSpecification API_PATH_FORM_FILTERS = getReqSpec("/formfilters");
    protected static final RequestSpecification API_PATH_SAVE_FORM = getReqSpec("/saveForm");

    protected static final String SESSION_ID = getDbConnectionAndGetSessionId();

    @Step("GET запрос '/dbconnection'. Вернуть sessionID")
    public static String getDbConnectionAndGetSessionId() {
        return RestAssured.given().spec(API_PATH).
                when().
                get("?login=" + LOGIN + "&password=" + PASSWORD)
                .then().
                statusCode(200).
                extract().path("sessionID");
    }

    /** Передает параметры из файла Project.properties */
    static ProjectProperties getProjectProperties() {
        return ConfigFactory.newInstance().create(ProjectProperties.class, System.getProperties());
    }

    public static RequestSpecification getReqSpec(String apiPath) {
        return new RequestSpecBuilder().
                setBaseUri(API_URL).
                setBasePath(apiPath).
                setContentType(ContentType.JSON).
                build();
    }
}
