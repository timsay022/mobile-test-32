package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:android.properties"})
public interface BrowserstackConfig extends Config {

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("projectName")
    String projectName();

    @Key("buildName")
    String buildName();

    @Key("name")
    String name();

    @Key("remoteUrl")
    String browserstackUrl();

}
