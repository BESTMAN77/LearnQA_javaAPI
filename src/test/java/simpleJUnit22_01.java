import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class simpleJUnit22_01 {
    @Test
    public void simpleTestJUnit() {
        Response response = RestAssured

        .get("https://playground.learnqa.ru/api/map")
        .andReturn();

        assertEquals(200,response.statusCode(), "неправильный статус код");
    }
}