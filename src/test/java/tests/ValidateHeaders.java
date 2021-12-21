package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class ValidateHeaders {

    @Test(groups = "HEADERS")
    @Feature("Проверить заголовки")
    @Story("TA-1В-1")
    @Description("Заголовки ответа на GET запрос получения sessionID ссответствуют ожидаемым")
    public void getDbConnectionValidateHeaders() {
        // TODO
    }

    @Test(groups = "HEADERS")
    @Feature("Проверить заголовки")
    @Story("TA-1В-2")
    @Description("Заголовки ответа на GET запрос списка форм ссответствуют ожидаемым")
    public void getFormsValidateHeaders() {
        // TODO
    }

    @Test(groups = "HEADERS")
    @Feature("Проверить заголовки")
    @Story("TA-1В-3")
    @Description("Заголовки ответа на GET запрос формы по id ссответствуют ожидаемым")
    public void getFormByIdValidateHeaders() {
        // TODO
    }

    @Test(groups = "HEADERS")
    @Feature("Проверить заголовки")
    @Story("TA-1В-4")
    @Description("Заголовки ответа на GET запрос фильтров для формы по id ссответствуют ожидаемым")
    public void getFormFiltersValidateHeaders() {
        // TODO
    }

    @Test(groups = "HEADERS")
    @Feature("Проверить заголовки")
    @Story("TA-1В-5")
    @Description("Заголовки ответа на POST запрос с JSON-обьектом ссответствуют ожидаемым")
    public void postSaveFormValidateHeaders() {
        // TODO
    }
}
