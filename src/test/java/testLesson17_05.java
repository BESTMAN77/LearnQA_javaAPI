import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class testLesson17_05 {
    @Test
    public void testHelloWorldLesson17_05(){ // В рамках этой задачи нужно создать тест, который будет делать GET-запрос на адрес https://playground.learnqa.ru/api/get_json_homework
        // Map<String,String> params = new HashMap<>();
        //params.put("messages","John");

        JsonPath response = RestAssured
                .given()
                //.queryParams(params)
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        String answer = response.get("messages");
        System.out.println(answer);

    }
}
