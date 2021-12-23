package tests.negative.validData;

import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.LogListener;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class StatusCode {

    @Test(groups = { "SMOKE", "dbconnection" })
    @Feature("Проверить код состояния")
    @Story("TA-2А-1")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Авторизация в системе с неверным логином и паролем возвращает ошибку авторизации")
    public void dbConnectionWrongLoginDataStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "forms" })
    @Feature("Проверить код состояния")
    @Story("TA-2А-2")
    @Severity(SeverityLevel.BLOCKER)
    @Description("GET запрос списка форм с невалидным sessionID возвращает ошибку")
    public void getFormsWrongSessionIdStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "form" })
    @Feature("Проверить код состояния")
    @Story("TA-2А-3")
    @Severity(SeverityLevel.BLOCKER)
    @Description("GET запрос формы по неверному id возвращает ошибку")
    public void getFormByWrongIdStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "formfilters" })
    @Feature("Проверить код состояния")
    @Story("TA-2А-4")
    @Severity(SeverityLevel.BLOCKER)
    @Description("GET запрос фильтров для формы по неверному id возвращает ошибку")
    public void getFormFiltersByWrongIdStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "saveForm" })
    @Feature("Проверить код состояния")
    @Story("TA-2А-5")
    @Severity(SeverityLevel.BLOCKER)
    @Description("POST запрос с невалидным JSON-обьектом возвращает ошибку")
    public void postSaveFormWrongJsonStatusCodeTest() {
        // TODO
    }
}
