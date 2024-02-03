import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class testLesson17_05 {
    @Test
    public void testHelloWorldLesson17_05(){ // В рамках этой задачи нужно создать тест, который будет делать GET-запрос на адрес https://playground.learnqa.ru/api/get_json_homework


        JsonPath response = RestAssured

                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();



        response.prettyPrint();

    }
}
