package config;

import io.restassured.RestAssured;

public class APIConfig {
    public static void setUp() {
        RestAssured.baseURI = "https://api.restful-api.dev/";
        // Additional common configurations can be added here
    }
}
