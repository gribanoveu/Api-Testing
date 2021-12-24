package tests.wrongData;

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
public class CorrectLoadingWrongData {

    @Flaky
    @Test(groups = { "dbconnection", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-1")
    @Description("Авторизация в системе с  недопустимыми символами логина и пароля возвращает JSON-обьект с сообщением об ошибке")
    public void getDbConnectionIllegalLoginValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "dbconnection", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-2")
    @Description("GET запрос списка форм с недопустимыми символами sessionID возвращает  JSON-обьект с сообщением об ошибке")
    public void getDbConnectionIllegalSessionIdValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "form", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-3")
    @Description("GET запрос формы с недопустимыми символами id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormByIllegalIdValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "formfilters", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-4")
    @Description("GET запрос фильтров для формы с недопустимыми символами id возвращает JSON-обьект с сообщением об ошибке")
    public void getFormFiltersIllegalFormIdValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "saveForm", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-5")
    @Description("POST запрос с недопустимыми символами в JSON-обьекте с сообщением об ошибке")
    public void postSaveFormIllegalJsonValidateSchemaTest() {
        // TODO
    }

    @Flaky
    @Test(groups = { "dbconnection", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-6")
    @Description("Авторизация в системе с строкой null в логине и пароле возвращает JSON-обьект с сообщением об ошибке")
    public void getDbConnectionNullInLoginValidateSchemaTest () {
        // TODO
    }

    @Flaky
    @Test(groups = { "dbconnection", "illegalData", "schema" })
    @Feature("Проверить правильность загрузки")
    @Story("TA-3Б-7")
    @Description("Отправка недопустимого запроса (PATCH, DELETE, PUT) возвращает сообщение об ошибке")
    public void sendInvalidRequestValidateSchemaTest() {
        // TODO
    }

}
