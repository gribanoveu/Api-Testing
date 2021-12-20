package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import steps.DbConnectionSteps;
import steps.FormResponseSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StatusCode {

    @Test
    public void dbConnectionReturnStatusCodeOkTest() {
        int statusCode = DbConnectionSteps.getDbConnectionStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /dbconnection возвращает статус код: " + statusCode);
    }

    @Test
    public void getFormByIdReturnStatusCodeOkTest() {

    }

    @Test
    public void getFormFiltersReturnStatusCodeOkTest() {
        int statusCode = FormResponseSteps.getFormResponseStatusCode();
        assertThat(statusCode).isEqualTo(200);
        log.info("GET запрос /forms возвращает статус код: " + statusCode);
    }

    @Test
    public void getFormsReturnStatusCodeOkTest() {}

    @Test
    public void postSaveFormReturnStatusCodeOkTest() {}
}
