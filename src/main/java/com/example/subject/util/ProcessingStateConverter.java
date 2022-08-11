package com.example.subject.util;

import com.example.subject.domain.code.ProcessingState;
import org.springframework.core.convert.converter.Converter;

public class ProcessingStateConverter implements Converter<String, ProcessingState> {


    @Override
    public ProcessingState convert(String processingState) {return ProcessingState.valueOf(processingState);
    }
}
