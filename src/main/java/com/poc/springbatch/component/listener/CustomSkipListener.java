package com.poc.springbatch.component.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.springbatch.entity.Employee;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

/*
This custom listener will listen ItemReader, ItemProcessor, ItemWriter for any exceptions. If occurred then intimate the user
 */
@Component
public class CustomSkipListener implements SkipListener<Employee, Number> {

    Logger logger = LoggerFactory.getLogger(CustomSkipListener.class);

    @Override // item reader
    public void onSkipInRead(Throwable throwable) {
        logger.info("A failure on read {} ", throwable.getMessage());
    }

    @Override // item writer
    public void onSkipInWrite(Number item, Throwable throwable) {
        logger.info("A failure on write {} , {}", throwable.getMessage(), item);
    }

    @SneakyThrows
    @Override // item processor
    public void onSkipInProcess(Employee employee, Throwable throwable) {
        logger.info("Item {}  was skipped due to the exception  {}", new ObjectMapper().writeValueAsString(employee),
                throwable.getMessage());
    }
}
