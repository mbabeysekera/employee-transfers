package com.jobfinder.api.employee_transfers.config.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Configuration
@ConfigurationProperties(prefix = "api")
public class AppConfigProperties {
    private App app;
}