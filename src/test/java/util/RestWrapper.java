package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

public abstract class RestWrapper {
    protected static final String API_URL = getProjectProperties().apiUrl();
    protected static final String LOGIN = getProjectProperties().apiLogin();
    protected static final String PASSWORD = getProjectProperties().apiPassword();

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
