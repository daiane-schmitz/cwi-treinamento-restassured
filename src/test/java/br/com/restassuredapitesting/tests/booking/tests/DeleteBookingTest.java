package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.nullValue;

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
                .statusCode(201);
    }

}
