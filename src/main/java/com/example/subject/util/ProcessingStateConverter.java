package com.example.subject.util;

import com.example.subject.domain.ProcessingState;
import com.example.subject.domain.UsageType;
import org.springframework.core.convert.converter.Converter;

public class ProcessingStateConverter implements Converter<String, ProcessingState> {


    @Override
    public ProcessingState convert(String processingState) {return ProcessingState.valueOf(processingState);
    }
}
