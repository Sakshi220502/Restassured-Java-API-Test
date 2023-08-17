package tests;

import io.restassured.RestAssured;
import config.APIConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPITest {

    @BeforeClass
    public void setUp() {
        APIConfig.setUp();
    }

    @Test
    public void testGetCall() {
        Response response = given()
        .get("/objects/7");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Response status code doesn't match expected value");

        String responseBody = response.getBody().asString();
        System.out.println("GET Response Body: " + responseBody);

        // Validate specific values using JSONPath
        String expectedName = "Apple MacBook Pro 16";
        int expectedYear = 2019;
        double expectedPrice = 1849.99;
        String expectedCPUModel = "Intel Core i9";
        String expectedHardDiskSize = "1 TB";

        Assert.assertTrue(responseBody.contains(expectedName), "Name value not found in the response");
        Assert.assertTrue(responseBody.contains("\"year\":" + expectedYear), "Year value not found in the response");
        Assert.assertTrue(responseBody.contains("\"price\":" + expectedPrice), "Price value not found in the response");
        Assert.assertTrue(responseBody.contains("\"CPU model\":\"" + expectedCPUModel + "\""), "CPU model value not found in the response");
        Assert.assertTrue(responseBody.contains("\"Hard disk size\":\"" + expectedHardDiskSize + "\""), "Hard disk size value not found in the response");
    }
}
