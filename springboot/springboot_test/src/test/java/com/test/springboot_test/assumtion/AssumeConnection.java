package com.test.springboot_test.assumtion;


import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(AssumeConnectionCondition.class)
public @interface AssumeConnection {

    String uri();

}
