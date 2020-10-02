package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.lessThan;

public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Acceptance.class)
    @DisplayName("Criar uma nova reserva")
    public void criarUmaNovaReserva() throws Exception{
        postBookingRequest.postBooking(Utils.validPayloadBooking()).then()
                .statusCode(200)
                .time(lessThan(4L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "postbooking"))));

    }
}
