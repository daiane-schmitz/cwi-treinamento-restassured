package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.E2e;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;


public class DeleteBookingTest extends BaseTest {

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Excluir um reserva com sucesso")
    public void excluirUmaReservaPorId() throws Exception{
        int id =  getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");

        deleteBookingRequest.excluirReserva(id).then()
                .statusCode(201)
                .time(lessThan(4L), TimeUnit.SECONDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(E2e.class)
    @DisplayName("Tentar excluir um reserva que não existe")
    public void excluirUmaReservaInexistente() throws Exception{
        int id =  10900;

        deleteBookingRequest.excluirReserva(id).then()
                .statusCode(405)
                .time(lessThan(4L), TimeUnit.SECONDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(E2e.class)
    @DisplayName("Tentar excluir um reserva sem autorização")
    public void excluirUmaReservaSemAutorizacao() throws Exception{
        int id =  getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");

        deleteBookingRequest.excluirReservaSemAutorizacao(id).then()
                .statusCode(403)
                .time(lessThan(4L), TimeUnit.SECONDS);
    }

}
