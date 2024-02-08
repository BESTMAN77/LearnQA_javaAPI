import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class testLessonCookieOutput21_09 {
    @Test
    public void cookie21_09(){
        Map<String,String> data = new HashMap<>();
        data.put("login","secret_login");
        data.put("password","secret_pass");

        Response response = RestAssured
        .given()
        .body(data)
        .when()
        .post("https://playground.learnqa.ru/api/get_auth_cookie")
        .andReturn();

        System.out.println("\npretty text:");
        response.prettyPrint();

        System.out.println("\nresponseHeaders:");
        Headers responsHeaders = response.getHeaders();
        System.out.println(responsHeaders);

        System.out.println("\nCookie:");
        Map<String,String> responseCookie = response.getCookies();
        System.out.println(responseCookie);
    }
}
