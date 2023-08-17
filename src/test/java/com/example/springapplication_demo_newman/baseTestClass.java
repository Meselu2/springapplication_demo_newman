package com.example.springapplication_demo_newman;

import com.example.springapplication_demo_newman.controller.EvenOddController;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

public class baseTestClass {

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new EvenOddController());
    }
}
