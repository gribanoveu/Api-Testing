package tests.validData;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.LogListener;

@Slf4j
@Listeners(LogListener.class)
public class CorrectLoadingValidData {

    @Flaky
    @Test(groups = { "dbconnection", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-1")
    @Description("Авторизация в системе с неверным логином и паролем возвращает JSON-обьект с сообщением об ошибке")
    public void getDbConnectionValidSessionIdValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "forms", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-2")
    @Description("GET запрос списка форм с валидным sessionID возвращает  JSON-обьект с сообщением об ошибке")
    public void getFormsValidSessionIdValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "form", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-3")
    @Description("GET запрос формы по неверному id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormByValidIdValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "formfilters", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-4")
    @Description("GET запрос фильтров для формы по неверному id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormFiltersValidFormIdValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "saveForm", "schema", "validData" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-2Б-5")
    @Description("POST запрос с невалидным JSON-обьектом возвращает JSON-обьект с сообщением об ошибке")
    public void postSaveFormValidJsonValidateSchemaTest() {
        // TODO
    }
}
