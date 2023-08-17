package tests;

import io.restassured.RestAssured;
import config.APIConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class PostAPITest {

    @BeforeClass
    public void setUp() {
        APIConfig.setUp();
    }

    @Test
    public void testPostCall() {
        String requestBody = "{\n" +
        "    \"name\": \"Apple MacBook Pro 16\",\n" +
        "    \"data\": {\n" +
        "        \"year\": 2019,\n" +
        "        \"price\": 1849.99,\n" +
        "        \"CPU model\": \"Intel Core i9\",\n" +
        "        \"Hard disk size\": \"1 TB\"\n" +
        "    }\n" +
        "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/objects");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Response status code doesn't match expected value");

        String responseBody = response.getBody().asString();
        System.out.println("POST Response Body: " + responseBody);

        // Validate some of the response fields
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

        // Validate the createdAt field using a dynamic approach

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        //OffsetDateTime currentOffsetDateTime = OffsetDateTime.now(ZoneOffset.UTC);
        //String currentTime = currentOffsetDateTime.format(formatter);
        //Assert.assertTrue(responseBody.contains(currentTime.substring(0, 22)), "createdAt value not found in the response");
        
    }
}
