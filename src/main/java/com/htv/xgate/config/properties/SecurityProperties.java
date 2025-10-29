package com.htv.xgate.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    List<String> permitAll;
    List<String> crossOrigin;
    boolean credentials;
    List<String> allowedMethods;
    List<String> allowedHeaders;
}
