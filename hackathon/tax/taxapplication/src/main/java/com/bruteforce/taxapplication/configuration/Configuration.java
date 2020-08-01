package com.bruteforce.taxapplication.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("configuration")
public class Configuration {

    @Value("${server.name:taxapp}")
    public String serverName;

}
