package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import steps.Auth;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BaseTest {
    private static final String AUTH_TOKEN = Auth.getTokenAfterLogin();

    @Test
    public void AuthTokenIsNotEmpty() {
        assertThat(AUTH_TOKEN).isNotEmpty();
        log.info("Auth OK");
    }
}
