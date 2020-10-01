package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.ping.requests.HealthcheckRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HealthCheckTest extends BaseTest {

    HealthcheckRequest getPingRequest = new HealthcheckRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(br.com.restassuredapitesting.suites.Healthcheck.class)
    @DisplayName("Verificar se API está online")
    public void VerificarAPIOnline() throws Exception {
        getPingRequest.ping().then()
                .statusCode(201);
    }

}
