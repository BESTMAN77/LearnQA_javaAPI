import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class testLesson17_05 {
    @Test
    public void testHelloWorldLesson17_05(){ // Необходимо написать тест, который создает GET-запрос
                                            // на адрес: https://playground.learnqa.ru/api/long_redirect
                                            //С этого адреса должен происходит редирект на другой адрес.
                                             // Наша задача — распечатать адрес, на который редиректит указанные URL.

        Response response = RestAssured

                .given()
                .redirects()
                .follow(false)
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);

    }
}
