package com.poc.springbatch.component.policy;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

public class CustomSkipPolicy implements SkipPolicy {
    @Override
    public boolean shouldSkip(Throwable t, long skipCount) throws SkipLimitExceededException {
        // you can use skipCount too for some check
        return t instanceof FlatFileParseException; // if true means i want to apply the skip
    }
}
