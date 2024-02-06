import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class testLessonHeaders20_08 {
    @Test
    public void testHelloWorldLesson20_08(){
        Map<String,String> headers = new HashMap<>();
        headers.put("myHeader1", "myValue1");
        headers.put("myHeader2", "myValue2");

        Response response = RestAssured

                .given()
                .headers(headers)
                .when()
                .get("https://playground.learnqa.ru/api/show_all_headers")
                .andReturn();

        response.prettyPrint(); /* заголовок что МЫ шлём серверу */

        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders); /* заголовок что НАМ прислал сервер */

    }
}
