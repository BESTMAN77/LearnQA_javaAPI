import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class testLesson18_06 {
    @Test
    public void testHelloWorldLesson18_06() { //Необходимо написать тест, который создает GET-запрос на адрес из предыдущего задания: https://playground.learnqa.ru/api/long_redirect
        //запрещаем переходить по ссылкам и получаем статус код
        Response response = RestAssured

                .given()
                .redirects()
                .follow(false)
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
}