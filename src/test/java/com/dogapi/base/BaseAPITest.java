package com.dogapi.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dog.ceo/api";
    }
}