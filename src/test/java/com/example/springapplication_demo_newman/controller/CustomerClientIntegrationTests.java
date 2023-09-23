package com.example.springapplication_demo_newman.controller;

import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;


@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example:spring-application-demo2:+:stubs:8084")
public class CustomerClientIntegrationTests {

    private CustomerClient customerClient;
    @BeforeEach
    void setup() {
        customerClient = new CustomerClient(“http://localhost:6565”);
    }

    @Test
    void testCustomerCreation() {
        Customer customer = new Customer(“Peter Pan”, 2233445566);
        String ref = customerClient.create(customer);
        assertNotNull(ref);
        assertEquals(5, ref.length());
        assertTrue(isNumeric(ref));
    }

}