import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class testLesson16_04 {
        @Test
        public void testHelloWorldLesson16_04(){ //тест
            Map<String,String> params = new HashMap<>();
            params.put("name","John");

            JsonPath response = RestAssured
                    .given()
                    .queryParams(params)
                    .get("https://playground.learnqa.ru/api/hello" /*"https://playground.learnqa.ru/api/hello"*/)
                    .jsonPath();

            String answer = response.get("answer");
            System.out.println(answer);
        }
}
