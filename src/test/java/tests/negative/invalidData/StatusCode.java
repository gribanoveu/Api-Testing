package tests.negative.invalidData;

import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.LogListener;

@Slf4j
@Listeners(LogListener.class)
public class StatusCode {

    @Test(groups = { "SMOKE", "dbconnection" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-1")
    @Severity(SeverityLevel.BLOCKER)
    @Description("")
    public void dbConnectionInvalidLoginDataStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "forms" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-2")
    @Severity(SeverityLevel.BLOCKER)
    @Description("")
    public void getFormsInvalidSessionIdStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "form" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-3")
    @Severity(SeverityLevel.BLOCKER)
    @Description("")
    public void getFormByInvalidIdStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "formfilters" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-4")
    @Severity(SeverityLevel.BLOCKER)
    @Description("")
    public void getFormFiltersByInvalidIdStatusCodeTest() {
        // TODO
    }

    @Test(groups = { "SMOKE", "saveForm" })
    @Feature("Проверить код состояния")
    @Story("TA-3А-5")
    @Severity(SeverityLevel.BLOCKER)
    @Description("")
    public void postSaveFormInvalidJsonStatusCodeTest() {
        // TODO
    }
}
