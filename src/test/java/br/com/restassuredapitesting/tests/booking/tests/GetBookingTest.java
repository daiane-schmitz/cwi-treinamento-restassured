package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Feature("Reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs das Reservas")
    public void listarIDsDasReservas() throws Exception{
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato de retorno da lista de reservas")
    public void garantirContratoListaReservas() throws Exception{
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno de uma reserva específica")
    public void garantirContratoReservaEspecifica() throws Exception{
        int id = getBookingRequest.allBookings().then().statusCode(200).extract().path("[2].bookingid");

        getBookingRequest.bookingByID(id).then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "booking"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma reserva específica")
    public void listarReservasPorID() throws Exception{
        int id = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");

        getBookingRequest.bookingByID(id).then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "booking"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs de reservas utilizando o filtro firstname")
    public void listarReservasPorFirstname() throws Exception{
        getBookingRequest.bookingByFirstname().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
        }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs de reservas utilizando o filtro lastname")
    public void listarReservasPorLastname() throws Exception{
        getBookingRequest.bookingByLastname().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs de reservas utilizando o filtro checkin")
    public void listarReservasPorChekin() throws Exception{
        getBookingRequest.bookingByCheckin().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs de reservas utilizando o filtro checkout")
    public void listarReservasPorChekout() throws Exception{
        getBookingRequest.bookingByCheckout().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs de reservas utilizando o filtros checkin e checkout")
    public void listarReservasPorCheckinEChekout() throws Exception{
        getBookingRequest.bookingCheckinCheckout().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs de reservas utilizando o filtros name, checkin e checkout")
    public void listarReservasPorNameCheckinEChekout() throws Exception{
        getBookingRequest.bookingNameCheckinCheckout().then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }


}
