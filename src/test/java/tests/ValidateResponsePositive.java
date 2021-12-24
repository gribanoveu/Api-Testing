package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.ValidateResponsePositiveSteps;
import util.LogListener;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class ValidateResponsePositive {
    ValidateResponsePositiveSteps validateResponseSteps = new ValidateResponsePositiveSteps();

    @Test(groups = { "SMOKE", "dbconnection" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-1")
    @Description("Авторизация в системе с корректным логином и паролем возвращает sessionID")
    public void getDbConnectionReturnSessionIdTest() {
        var sessionIdLength = validateResponseSteps.dbConnectionReturnSessionId();
        assertThat(sessionIdLength).isNotNull();
        log.info("Длина токена составляет: " + sessionIdLength + " символов");
    }

    @Test(groups = { "dbconnection", "schema" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-2")
    @Description(" Структура ответа JSON для получения sessionID соответствует модели данных")
    public void getDbConnectionValidateSchemaTest() {
        validateResponseSteps.getDbConnectionValidateSchema();
    }

    @Test(groups = { "forms", "schema" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-3")
    @Description("Структура ответа JSON для получения списка форм соответствует модели данных")
    public void getFormsValidateSchemaTest() {
        List<String> names = new LinkedList<>();
        names.add("01. Параметры");
        names.add("02. Выручка");
        names.add("03. ФОТ ПП");
        names.add("04. Распределение расходов");
        names.add("06. Анализ");
        validateResponseSteps.getFormsContainNames(names);
    }

    @Test(groups = { "form", "schema" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-4")
    @Description("Структура ответа JSON для получения формы по id соответствует модели данных")
    public void getFormByIdValidateSchemaTest() {
        validateResponseSteps.getFormByIdContainsFields();
    }

    @Test(groups = { "formfilters", "schema" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-5")
    @Description("Структура ответа JSON для получения фильтров формы по id соответствует модели данных")
    public void getFormFiltersValidateSchemaTest() {
        validateResponseSteps.getFormFiltersContainsFields();
    }

    @Flaky
    @Test(groups = { "saveForm", "schema" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-6")
    @Description("Структура ответа JSON после POST запроса с JSON-обьектом возвращает " +
                 "новый JSON-обьект с обновленными после слияния значениями и соответствует модели данных")
    public void postSaveFormValidateSchemaTest() {
        // TODO нет ответа json от заглушки
    }
}
