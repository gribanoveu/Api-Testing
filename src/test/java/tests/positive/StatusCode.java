package tests.positive;

import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.StatusCodePositiveSteps;
import util.LogListener;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class StatusCode {
    StatusCodePositiveSteps statusCodePositiveSteps = new StatusCodePositiveSteps();

    @Test(groups = { "SMOKE", "dbconnection" })
    @Feature("Проверить код состояния")
    @Story("TA-1А-1")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Авторизация в системе с корректным логином и паролем возвращает Status Code 200 ОК")
    public void dbConnectionReturnStatusCodeOkTest() {
        var statusCode = statusCodePositiveSteps.getDbConnectionStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /dbconnection возвращает статус код: " + statusCode);
    }

    @Test(groups = { "SMOKE", "forms" })
    @Feature("Проверить код состояния")
    @Story("TA-1А-2")
    @Severity(SeverityLevel.BLOCKER)
    @Description("GET запрос списка форм возвращает Status Code 200 ОК")
    public void getFormsReturnStatusCodeOkTest() {
        var statusCode = statusCodePositiveSteps.getFormsResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test(groups = { "SMOKE", "form" })
    @Feature("Проверить код состояния")
    @Story("TA-1А-3")
    @Severity(SeverityLevel.BLOCKER)
    @Description("GET запрос формы по id возвращает Status Code 200 ОК")
    public void getFormByIdReturnStatusCodeOkTest() {
        var statusCode = statusCodePositiveSteps.getFormByIdResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test(groups = { "SMOKE", "formfilters" })
    @Feature("Проверить код состояния")
    @Story("TA-1А-4")
    @Severity(SeverityLevel.BLOCKER)
    @Description("GET запрос фильтров для формы по id возвращает Status Code 200 ОК")
    public void getFormFiltersReturnStatusCodeOkTest() {
        var statusCode = statusCodePositiveSteps.getFormFiltersResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test(groups = { "SMOKE", "saveForm" })
    @Feature("Проверить код состояния")
    @Story("TA-1А-5")
    @Severity(SeverityLevel.BLOCKER)
    @Description("POST запрос с валидным JSON-обьектом возвращает Status Code 200 ОК")
    public void postSaveFormReturnStatusCodeOkTest() {
        var statusCode = statusCodePositiveSteps.postSaveFormResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }
}
