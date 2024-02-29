package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.Assertions;
import lib.baseTestcase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserGetTest extends baseTestcase {
    @Test
    public void getUserDataNotAuth(){
        Response responseUserData = RestAssured
                .get("https://playground.learnqa.ru/api/user/2")
                .andReturn();


        Assertions.assertJsonHasField(responseUserData, "username");
        Assertions.assertJsonHasNotField(responseUserData,"lastName");
        Assertions.assertJsonHasNotField(responseUserData,"firstName");
        Assertions.assertJsonHasNotField(responseUserData,"email");
    }

    @Test
    public void getUserDetailAuthSameUser(){
        Map<String,String> authData = new HashMap<>();
        authData.put("email","vinkotov@example.com");
        authData.put("password","1234");

        Response responseGetAuth = RestAssured
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/user/login")
                .andReturn();

        String header = this.getHeaders(responseGetAuth,"x-csrf-token");
        String cookie = this.getCookies(responseGetAuth,"user_sid");

        Response responseGetUser = RestAssured
                .given()
                .header("x-csrf-token",header)
                .cookie("user_sid",cookie)
                .get("https://playground.learnqa.ru/api/user/2")
                .andReturn();

        String[] expectedFields = {"username","firstName","lastName","email"};
        Assertions.assertJsonHasFields(responseGetUser,expectedFields);
    }
}
