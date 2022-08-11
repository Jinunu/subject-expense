package com.example.subject.util;

import com.example.subject.domain.code.UsageType;
import org.springframework.core.convert.converter.Converter;

public class UsageTypeConverter implements Converter<String, UsageType> {


    @Override
    public UsageType convert(String usageType) {
        return UsageType.valueOf(usageType);
    }
}
