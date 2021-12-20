package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import steps.GetApiRequestStatusCodeSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StatusCode {

    @Test
    public void dbConnectionReturnStatusCodeOkTest() {
        int statusCode = GetApiRequestStatusCodeSteps.getDbConnectionStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /dbconnection возвращает статус код: " + statusCode);
    }

    @Test
    public void getFormByIdReturnStatusCodeOkTest() {

    }

    @Test
    public void getFormFiltersReturnStatusCodeOkTest() {
        int statusCode = GetApiRequestStatusCodeSteps.getFormResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test
    public void getFormsReturnStatusCodeOkTest() {}

    @Test
    public void postSaveFormReturnStatusCodeOkTest() {}
}
