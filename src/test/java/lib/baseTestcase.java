package lib;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.hasKey;

public class baseTestcase {
    protected String getHeaders(Response response, String name) {
        Headers headers = response.getHeaders();

        assertTrue(headers.hasHeaderWithName(name),"Response doesn't have headers with: " + name);
        return headers.getValue(name);
    }
    protected String getCookies(Response response, String name) {
        Map<String,String> cookies = response.getCookies();

        assertTrue(cookies.containsKey(name),"Response doesn't have cookies with: " + name);
        return cookies.get(name);
    }
    protected int getIntFromJson(Response response,String name){
        response.then().assertThat().body("$",hasKey(name));
        return response.jsonPath().getInt(name);
    }
}
