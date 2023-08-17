package ii.service.ga;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HealthCheckRunner {
    HealthCheckRunner() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getServiceStatus() {

        given().
                when().
                get("/posts").
                then().
                assertThat().
                statusCode(200).
                body("[0].userId", equalTo(1));
     }

}

