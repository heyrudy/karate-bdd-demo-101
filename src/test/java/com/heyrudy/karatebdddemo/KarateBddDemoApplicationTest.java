package com.heyrudy.karatebdddemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KarateBddDemoApplicationTest {

    @Autowired
    KarateBddDemoApplication application;

    @Test
    void contextLoads() {
        Assertions.assertThat(application).isNotNull();
    }

}
