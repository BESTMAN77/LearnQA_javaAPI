package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.Assertions;
import lib.DataGeneration;
import lib.baseTestcase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserRegisterTest extends baseTestcase {
    @Test
    public void testCreateUserWithExistingEmail() {
        String email = "vinkotov@example.com";


        Map<String,String> userData = new HashMap<>();
        userData.put("username","learnqa");
        userData.put("firstName","learnqa");
        userData.put("lastName","learnqa");
        userData.put("email",email);
        userData.put("password","123");

        Response responseCreateAuth = RestAssured
                .given()
                .body(userData)
                .post("https://playground.learnqa.ru/api/user/")
                .andReturn();

        Assertions.assertResponseStatuscodeEquals(responseCreateAuth,400);
        Assertions.assertResponseTextEquals(responseCreateAuth,"Users with email '" + email + "' already exists");
    }
    @Test
    public void testCreateUserSuccessfully() {
        String email = DataGeneration.getRandomEmail();


        Map<String,String> userData = new HashMap<>();
        userData.put("username","learnqa");
        userData.put("firstName","learnqa");
        userData.put("lastName","learnqa");
        userData.put("email",email);
        userData.put("password","123");

        Response responseCreateAuth = RestAssured
                .given()
                .body(userData)
                .post("https://playground.learnqa.ru/api/user/")
                .andReturn();

        Assertions.assertResponseStatuscodeEquals(responseCreateAuth,200);
        Assertions.assertJsonHasKey(responseCreateAuth,"id");
    }
}
