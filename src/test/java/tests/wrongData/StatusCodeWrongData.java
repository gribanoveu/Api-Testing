package tests.wrongData;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.wrongData.StatusCodeWrongDataSteps;
import util.LogListener;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class StatusCodeWrongData {
    StatusCodeWrongDataSteps statusCodeWrongDataSteps = new StatusCodeWrongDataSteps();

    @Flaky
    @Test(groups = { "dbconnection", "illegalData", "statusCode" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-1")
    @Description("Авторизация в системе с недопустимыми символами логина и пароля возвращает ошибку авторизации")
    public void dbConnectionInvalidLoginDataStatusCodeTest() {
        var statusCode = statusCodeWrongDataSteps.dbConnectionIllegalLoginData();
        assertThat(statusCode).isEqualTo(400);
        log.info("GET запрос /dbconnection возвращает статус код: " + statusCode);
    }

    @Flaky
    @Test(groups = { "forms", "illegalData", "statusCode" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-2")
    @Description("GET запрос списка форм с недопустимыми символами sessionID возвращает ошибку")
    public void getFormsInvalidSessionIdStatusCodeTest() {
        var statusCode = statusCodeWrongDataSteps.getFormsIllegalSessionId();
        assertThat(statusCode).isEqualTo(400);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Flaky
    @Test(groups = { "form", "illegalData", "statusCode" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-3")
    @Description("GET запрос формы с недопустимыми символами id возвращает ошибку")
    public void getFormByInvalidIdStatusCodeTest() {
        var statusCode = statusCodeWrongDataSteps.getFormByIllegalId();
        assertThat(statusCode).isEqualTo(400);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Flaky
    @Test(groups = { "formfilters", "illegalData", "statusCode" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-4")
    @Description("GET запрос фильтров для формы с недопустимыми символами id возвращает ошибку")
    public void getFormFiltersByInvalidIdStatusCodeTest() {
        var statusCode = statusCodeWrongDataSteps.getFormFiltersByIllegalId();
        assertThat(statusCode).isEqualTo(400);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Flaky
    @Test(groups = { "saveForm", "illegalData", "statusCode" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-5")
    @Description("POST запрос с недопустимыми символами в JSON-обьекте возвращает ошибку")
    public void postSaveFormInvalidJsonStatusCodeTest() {
        var statusCode = statusCodeWrongDataSteps.postSaveFormIllegalJson();
        assertThat(statusCode).isEqualTo(400);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }
}
