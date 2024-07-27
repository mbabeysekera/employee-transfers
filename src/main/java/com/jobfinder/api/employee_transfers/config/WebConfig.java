package com.jobfinder.api.employee_transfers.config;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class WebConfig {

    @Value("${web.cors.allowed-origins}")
    private String origins;
    @Value("${web.cors.allowed-methods}")
    private String methods;
    @Value("${web.cors.max-age}")
    private String maxAge;
    @Value("${web.cors.allowed-headers}")
    private String allowedHeaders;
    @Value("${web.cors.exposed-headers}")
    private String exposedHeaders;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(origins)
                        .allowedMethods(methods.split(", "))
                        .maxAge(Long.parseLong(maxAge))
                        .allowedHeaders(allowedHeaders)
                        .exposedHeaders(exposedHeaders);
            }
        };
    }
}
