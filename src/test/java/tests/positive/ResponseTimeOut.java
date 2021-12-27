package tests.positive;

import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.positive.ResponseTimeOutSteps;
import util.LogListener;

@Slf4j
@Listeners(LogListener.class)
public class ResponseTimeOut {
    ResponseTimeOutSteps responseTimeOutSteps = new ResponseTimeOutSteps();

    @Test(groups = { "SMOKE", "dbconnection", "positive", "statusCode" })
    @Feature("Проверить время ответа")
    @Story("TA-1А-1")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверить время ответа")
    public void dbConnectionReturnStatusCodeOkTest() {
        var timeout = responseTimeOutSteps.getDbConnectionTimeout();
        log.info("GET запрос /dbconnection timeout: " + timeout);
    }
}
