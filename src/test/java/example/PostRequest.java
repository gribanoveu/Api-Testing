package example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRequest {
    @Test
    public void postRequestExampleTest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "eve.holt@reqres.in");
        requestBody.put("password", "cityslicka");

        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());

        Response response = request.post("https://webhook.site/ab612b42-3482-40b6-a8aa-522be09b04f4");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("The status code recieved: " + statusCode);
    }
}
