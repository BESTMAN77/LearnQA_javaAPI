import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class parametrized23_02 {

    @ParameterizedTest
    @ValueSource(strings = {"", "John", "Adam"})
    public void testHelloMetodWithoutName(String name){
        Map<String, String> quaeryParams = new HashMap<>();

        if(name.length() > 0){
            quaeryParams.put("name", name);
        }

        JsonPath response = RestAssured
                .given()
                .queryParams(quaeryParams)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();

        String answer = response.getString("answer");
        String expectedName = (name.length() > 0) ? name : "someone";
        assertEquals("Hello, " + expectedName, answer,"The answer is not expected");

    }
}
