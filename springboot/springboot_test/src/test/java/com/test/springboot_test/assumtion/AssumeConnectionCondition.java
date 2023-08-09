package com.test.springboot_test.assumtion;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;


public class AssumeConnectionCondition implements ExecutionCondition {

    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AssumeConnectionCondition.class);


    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<AssumeConnection> annotation = findAnnotation(context.getElement(), AssumeConnection.class);

        logger.debug("가져온 Annotation Element Context : {} " , annotation);

        if(annotation.isPresent()) {
            String uri = annotation.get().uri();

            logger.info("THIS IS URI CLASS : {} ", uri);

            ConnectionChecker checker = new ConnectionChecker(uri);

            if(checker.connect()) {
                return ConditionEvaluationResult.disabled(String.format("Could not to '%s' . Skipping test !", uri));
            } else {
                return ConditionEvaluationResult.enabled(String.format("Successfully connected to '%s' . Connecting Test !", uri));
            }
        }
        return ConditionEvaluationResult.enabled("No AssumeConnection annotation found. Counting test. ");
    }

}
