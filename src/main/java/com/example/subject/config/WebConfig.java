package com.example.subject.config;

import com.example.subject.util.ProcessingStateConverter;
import com.example.subject.util.UsageTypeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new UsageTypeConverter());
        registry.addConverter(new ProcessingStateConverter());
    }
}
