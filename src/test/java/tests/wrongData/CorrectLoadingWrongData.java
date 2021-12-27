package tests.wrongData;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.wrongData.CorrectLoadingWrongDataSteps;
import util.LogListener;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class CorrectLoadingWrongData {
    CorrectLoadingWrongDataSteps correctLoadingWrongDataSteps = new CorrectLoadingWrongDataSteps();

    @Flaky
    @Test(groups = { "dbconnection", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-1")
    @Description("Авторизация в системе с  недопустимыми символами логина и пароля возвращает JSON-обьект с сообщением об ошибке")
    public void getDbConnectionIllegalLoginValidateSchemaTest() {
        var expectedMessage = correctLoadingWrongDataSteps.getDbConnectionIllegalLoginValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request. No login param"); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "forms", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-2")
    @Description("GET запрос списка форм с недопустимыми символами sessionID возвращает  JSON-обьект с сообщением об ошибке")
    public void getDbConnectionIllegalSessionIdValidateSchemaTest() {
        var expectedMessage = correctLoadingWrongDataSteps.getFormsIllegalSessionIdValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request. No login param"); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "form", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-3")
    @Description("GET запрос формы с недопустимыми символами id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormByIllegalIdValidateSchemaTest() {
        var expectedMessage = correctLoadingWrongDataSteps.getFormByIllegalIdValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request. No login param"); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "formfilters", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-4")
    @Description("GET запрос фильтров для формы с недопустимыми символами id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormFiltersIllegalFormIdValidateSchemaTest() {
        var expectedMessage = correctLoadingWrongDataSteps.getFormFiltersIllegalFormIdValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request. No login param"); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "saveForm", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-5")
    @Description("POST запрос с недопустимыми символами в JSON-обьекте с сообщением об ошибке")
    public void postSaveFormIllegalJsonValidateSchemaTest() {
        var expectedMessage = correctLoadingWrongDataSteps.postSaveFormIllegalJsonValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request. No login param"); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }

    @Flaky
    @Test(groups = { "dbconnection", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-6")
    @Description("Авторизация в системе с строкой null в логине и пароле возвращает JSON-обьект с сообщением об ошибке")
    public void getDbConnectionNullInLoginValidateSchemaTest () {
        var expectedMessage = correctLoadingWrongDataSteps.getDbConnectionNullInLoginValidateSchema();
        assertThat(expectedMessage).as("Тело ответа не соответствует заданному").
                contains("Bad Request. No login param"); // TODO добавить правильное сообщение об ошибке
        log.info("Тело ответа содержит: " + expectedMessage);
    }
}
