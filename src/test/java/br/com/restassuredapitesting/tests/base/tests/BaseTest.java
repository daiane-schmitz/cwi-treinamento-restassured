package br.com.restassuredapitesting.tests.base.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass

    public static void setup(){
        RestAssured.baseURI = "http://treinamento-api.herokuapp.com/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
