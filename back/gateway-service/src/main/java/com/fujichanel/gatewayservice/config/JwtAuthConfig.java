package com.fujichanel.gatewayservice.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Getter
@Validated
@ConfigurationProperties(prefix = "jwt.auth2.converter")
public class JwtAuthConfig {
    private String resourceId;
    private String principalAttribute;
}
