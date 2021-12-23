package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import util.RestWrapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ValidateHeadersSteps extends RestWrapper {

    public List<String> getDbConnectionValidateHeader(RequestSpecification requestSpecification) {
        RequestSpecification request = RestAssured.given().spec(requestSpecification).log().uri();
        Response response = request.get("?login=" + LOGIN + "&password=" + PASSWORD);

        String contentType = response.header("Content-Type");
        String contentLength = response.header("Content-Length");

        List<String> header = new ArrayList<String>();
        header.add(contentType);
        header.add(contentLength);

        log.info("Header GET запроса /dbconnection содержит Content-Type: " + contentType);
        log.info("Header GET запроса /dbconnection содержит Content-Length: " + contentLength);
        return header;
    }

    public String validateHeader(RequestSpecification requestSpecification) {
        RequestSpecification request = RestAssured.given().
                spec(requestSpecification).log().uri().
                header("sessionID", SESSION_ID).log().headers();
        Response response = request.get("?formid=" + FORM_ID);
        return response.header("Content-Type");
    }

    public String validateHeaderPost(RequestSpecification requestSpecification) {
        RequestSpecification request = RestAssured.given().
                spec(requestSpecification).log().uri().log().body().
                header("sessionID", SESSION_ID).log().headers();
        Response response = request.post("?formid=" + FORM_ID);
        return response.header("Content-Type");
    }

}
