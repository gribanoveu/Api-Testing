package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import util.ProjectProperties;

public abstract class BaseSteps {
    private static final String API_URL = getProjectProperties().apiUrl();

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
