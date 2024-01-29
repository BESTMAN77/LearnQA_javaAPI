import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    @Test
    public void testHelloWorld(){ //тест
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_text" /*"https://playground.learnqa.ru/api/hello"*/)
                 .andReturn();
        response.prettyPrint();
    }
}
