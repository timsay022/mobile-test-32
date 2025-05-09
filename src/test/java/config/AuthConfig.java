package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:auth.properties"})
public interface AuthConfig extends Config{

    @Config.Key("username")
    String username();

    @Config.Key("password")
    String password();
}
