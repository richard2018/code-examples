package io.reflectoring.customer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CustomerTestConfiguration.class)
class CustomerTestConfigurationTest {
    @Test
    void customerConfigurationLoads() {
        System.out.println("ddd");
    }
}
