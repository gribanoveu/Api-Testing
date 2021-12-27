package tests.validData;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.validData.CorrectLoadingValidDataSteps;
import util.LogListener;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class CorrectLoadingValidData {
    CorrectLoadingValidDataSteps correctLoadingValidDataSteps = new CorrectLoadingValidDataSteps();

    @Flaky
    @Test(groups = { "dbconnection", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-1")
    @Description("Авторизация в системе с неверным логином и паролем возвращает JSON-обьект с сообщением об ошибке")
    public void getDbConnectionValidSessionIdValidateSchemaTest() {
        var expectedMessage = correctLoadingValidDataSteps.getDbConnectionValidSessionIdValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request. No login param"); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "forms", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-2")
    @Description("GET запрос списка форм с валидным sessionID возвращает  JSON-обьект с сообщением об ошибке")
    public void getFormsValidSessionIdValidateSchemaTest() {
        var expectedMessage = correctLoadingValidDataSteps.getFormsValidSessionIdValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request."); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "form", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-3")
    @Description("GET запрос формы по неверному id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormByValidIdValidateSchemaTest() {
        var expectedMessage = correctLoadingValidDataSteps.getFormByValidIdValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request."); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "formfilters", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-4")
    @Description("GET запрос фильтров для формы по неверному id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormFiltersValidFormIdValidateSchemaTest() {
        var expectedMessage = correctLoadingValidDataSteps.getFormFiltersValidFormIdValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request."); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "saveForm", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-5")
    @Description("POST запрос с невалидным JSON-обьектом возвращает JSON-обьект с сообщением об ошибке")
    public void postSaveFormValidJsonValidateSchemaTest() {
        var expectedMessage = correctLoadingValidDataSteps.postSaveFormValidJsonValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request."); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }
}
