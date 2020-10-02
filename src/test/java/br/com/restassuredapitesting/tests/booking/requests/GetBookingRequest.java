package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Buscar todas as reservas")
    public Response allBookings(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking");
    }

    @Step("Buscar reserva específica por id")
    public Response bookingByID(int id){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking/" + id)
                .prettyPeek();
    }

    @Step("Listar IDs de reservas utilizando o filtro firstname")
    public Response bookingByFirstname(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .queryParam("firstname", "Mark")
                .get("booking/")
                .prettyPeek();
    }

    @Step("Listar IDs de reservas utilizando o filtro lastname")
    public Response bookingByLastname(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .queryParam("lastname", "Brown")
                .get("booking/")
                .prettyPeek();
    }

    @Step("Listar IDs de reservas utilizando o filtro checkin")
    public Response bookingByCheckin(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .queryParam("checkin", "2020-01-01")
                .get("booking/")
                .prettyPeek();
    }

    @Step("Listar IDs de reservas utilizando o filtro checkout")
    public Response bookingByCheckout(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .queryParam("checkout", "2020-01-01")
                .get("booking/")
                .prettyPeek();
    }

    @Step("Listar IDs de reservas utilizando o filtros checkin e checkout")
    public Response bookingCheckinCheckout(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .queryParam("checkin", "2019-10-10")
                .queryParam("checkout", "2020-01-01")
                .get("booking/")
                .prettyPeek();
    }

    @Step("Listar IDs de reservas utilizando o filtros name, checkin e checkout")
    public Response bookingNameCheckinCheckout(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .queryParam("firstname", "Mark")
                .queryParam("lastname", "Smith")
                .queryParam("checkin", "2017-01-10")
                .queryParam("checkout", "2017-08-01")
                .get("booking/")
                .prettyPeek();
    }



}
