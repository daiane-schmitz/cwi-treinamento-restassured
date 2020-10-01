package br.com.restassuredapitesting.tests.ping.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class HealthcheckRequest {

    @Step("Verificar se API está online")
    public Response ping(){
        return when()
                .get("ping");
    }

}
