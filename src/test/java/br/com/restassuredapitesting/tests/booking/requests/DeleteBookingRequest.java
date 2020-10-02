package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Step("Excluir um reserva com sucesso")
    public Response excluirReserva(int id) {
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", postAuthRequest.getToken())
                .when()
                .delete("booking/" + id)
                .prettyPeek();


    }

}
