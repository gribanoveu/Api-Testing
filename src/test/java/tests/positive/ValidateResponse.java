package tests.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import steps.ValidateSchemaSteps;


public class ValidateResponse {

    @Test(groups = { "SMOKE", "dbconnection" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-1")
    @Description("Авторизация в системе с корректным логином и паролем возвращает sessionID")
    public void getDbConnectionReturnSessionIdTest() {
        ValidateSchemaSteps.dbConnectionReturnSessionId();
    }

    @Test(groups = { "dbconnection" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-2")
    @Description(" Структура ответа JSON для получения sessionID соответствует модели данных")
    public void getDbConnectionValidateSchemaTest() {
        // TODO
    }

    @Test(groups = { "forms" })
    @Feature("Подтвердить загрузку ответа")
    @Story("TA-1Б-3")
    @Description("Структура ответа JSON для получения списка форм соответствует модели данных")
    public void getFormsValidateSchemaTest() {
        // TODO
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
