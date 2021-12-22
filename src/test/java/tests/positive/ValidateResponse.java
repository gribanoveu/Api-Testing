package tests.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import steps.ValidateResponseSteps;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ValidateResponse {

    @Test(groups = { "SMOKE", "dbconnection" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-1")
    @Description("Авторизация в системе с корректным логином и паролем возвращает sessionID")
    public void getDbConnectionReturnSessionIdTest() {
        ValidateResponseSteps.dbConnectionReturnSessionId();
    }

    @Test(groups = { "dbconnection" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-2")
    @Description(" Структура ответа JSON для получения sessionID соответствует модели данных")
    public void getDbConnectionValidateSchemaTest() {
        ValidateResponseSteps.getDbConnectionValidateSchema();
        log.info("Схема запроса /dbconnection совпадает с ожидаемой AUTH_SHEMA.json");
    }

    @Test(groups = { "forms" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-3")
    @Description("Структура ответа JSON для получения списка форм соответствует модели данных")
    public void getFormsValidateSchemaTest() {
        List<String> names = new LinkedList<String>();
        names.add("01. Параметры");
        names.add("02. Выручка");
        names.add("03. ФОТ ПП");
        names.add("04. Распределение расходов");
        names.add("06. Анализ");
        ValidateResponseSteps.getFormsValidateSchema(names);
    }

    @Test(groups = { "form" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-4")
    @Description("Структура ответа JSON для получения формы по id соответствует модели данных")
    public void getFormByIdValidateSchemaTest() {
        // TODO
    }

    @Test(groups = { "formfilters" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-5")
    @Description("Структура ответа JSON для получения фильтров формы по id соответствует модели данных")
    public void getFormFiltersValidateSchemaTest() {
        // TODO
    }

    @Test(groups = { "saveForm" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-6")
    @Description("Структура ответа JSON после POST запроса с JSON-обьектом возвращает " +
                 "новый JSON-обьект с обновленными после слияния значениями и соответствует модели данных")
    public void postSaveFormValidateSchemaTest() {
        // TODO
    }
}
