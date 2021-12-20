package util;

import org.aeonbits.owner.Config;

@Config.Sources({ "file:src/test/resources/Project.properties" })
public interface ProjectProperties extends Config {

    @Key("apiUrl")
    String apiUrl();

    @Key("apiLogin")
    String apiLogin();

    @Key("apiPassword")
    String apiPassword();
}
