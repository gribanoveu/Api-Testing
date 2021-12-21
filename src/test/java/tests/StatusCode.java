package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import steps.GetApiRequestStatusCodeSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StatusCode {

    @Test(groups = "SMOKE")
    @Feature("Проверить код состояния")
    @Story("TA-1А-1")
    @Description("Авторизация в системе с корректным логином и паролем возвращает Status Code 200 ОК")
    public void dbConnectionReturnStatusCodeOkTest() {
        var statusCode = GetApiRequestStatusCodeSteps.getDbConnectionStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /dbconnection возвращает статус код: " + statusCode);
    }

    @Test(groups = "SMOKE")
    @Feature("Проверить код состояния")
    @Story("TA-1А-2")
    @Description("GET запрос списка форм возвращает Status Code 200 ОК")
    public void getFormsReturnStatusCodeOkTest() {
        var statusCode = GetApiRequestStatusCodeSteps.getFormsResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test(groups = "SMOKE")
    @Feature("Проверить код состояния")
    @Story("TA-1А-3")
    @Description("GET запрос формы по id возвращает Status Code 200 ОК")
    public void getFormByIdReturnStatusCodeOkTest() {
        var statusCode = GetApiRequestStatusCodeSteps.getFormByIdResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test(groups = "SMOKE")
    @Feature("Проверить код состояния")
    @Story("TA-1А-4")
    @Description("GET запрос фильтров для формы по id возвращает Status Code 200 ОК")
    public void getFormFiltersReturnStatusCodeOkTest() {
        var statusCode = GetApiRequestStatusCodeSteps.getFormFiltersResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test(groups = "SMOKE")
    @Feature("Проверить код состояния")
    @Story("TA-1А-5")
    @Description("POST запрос с валидным JSON-обьектом возвращает Status Code 200 ОК")
    public void postSaveFormReturnStatusCodeOkTest() {
        var statusCode = GetApiRequestStatusCodeSteps.postSaveFormResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }
}
