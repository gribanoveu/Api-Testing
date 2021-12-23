package tests.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.ValidateHeadersSteps;
import util.LogListener;
import util.RestWrapper;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class ValidateHeaders extends RestWrapper {

    @Test(groups = { "dbconnection", "headers" })
    @Feature("Проверить заголовки")
    @Story("TA-1В-1")
    @Description("Заголовки ответа на GET запрос получения sessionID ссответствуют ожидаемым")
    public void getDbConnectionValidateHeaders() {
        var responseHeader = ValidateHeadersSteps.getDbConnectionValidateHeader(API_PATH_DBCONNECTION);
        assertThat(responseHeader).contains("application/json; charset=utf-8", "42");
    }

    @Test(groups = { "forms", "headers" })
    @Feature("Проверить заголовки")
    @Story("TA-1В-2")
    @Description("Заголовки ответа на GET запрос списка форм сответствуют ожидаемым")
    public void getFormsValidateHeaders() {
        var responseHeader = ValidateHeadersSteps.validateHeader(API_PATH_FORMS);
        log.info("Header GET запроса /forms содержит Content-Type: " + responseHeader);
        assertThat(responseHeader).contains("application/json; charset=utf-8");
    }

    @Test(groups = { "form", "headers" })
    @Feature("Проверить заголовки")
    @Story("TA-1В-3")
    @Description("Заголовки ответа на GET запрос формы по id ссответствуют ожидаемым")
    public void getFormByIdValidateHeaders() {
        var responseHeader = ValidateHeadersSteps.validateHeader(API_PATH_FORM);
        log.info("Header GET запроса /form содержит Content-Type: " + responseHeader);
        assertThat(responseHeader).contains("application/json; charset=utf-8");
    }

    @Test(groups = { "formfilters", "headers" })
    @Feature("Проверить заголовки")
    @Story("TA-1В-4")
    @Description("Заголовки ответа на GET запрос фильтров для формы по id ссответствуют ожидаемым")
    public void getFormFiltersValidateHeaders() {
        var responseHeader = ValidateHeadersSteps.validateHeader(API_PATH_FORM_FILTERS);
        log.info("Header GET запроса /formfilters содержит Content-Type: " + responseHeader);
        assertThat(responseHeader).contains("application/json; charset=utf-8");
    }

    @Test(groups = { "saveForm", "headers" })
    @Feature("Проверить заголовки")
    @Story("TA-1В-5")
    @Description("Заголовки ответа на POST запрос с JSON-обьектом ссответствуют ожидаемым")
    public void postSaveFormValidateHeaders() {
        var responseHeader = ValidateHeadersSteps.validateHeaderPost(API_PATH_SAVE_FORM);
        log.info("Header GET запроса /saveForm содержит Content-Type: " + responseHeader);
        assertThat(responseHeader).contains("application/json; charset=utf-8");
    }
}
