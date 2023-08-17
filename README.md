# Restassured-Java-API-Test

# RestAssured Demo -- Sakshi
This repo contains RestAssured boiler plate with API test cases as per Medibank Assessment

## Medibank Test Scenario

Task 2: Identify a best fit open-source tool for API automation and create Automated Tests for Get
and Post call validations covering below
* Response code validation
* Response message validation
* Validate a few particular values from response Json using Json path
* Test execution should produce a report having Pass fail statuses

Tool of choice is &quot;Rest Assure&quot; with Java, however you can use any other automation tools/library
using Java as programming languages, open Source APIs which can be used for creating the tests.
" https://restful-api.dev/ "

## Answers:

* Tests cases for GET & POST have been written. same cam be seen under src/test/java/tests GetAPITest.java & PostAPITest.java
* Response code validation script is included in tests
* Response message validation is included in the tests
* Few validations (assertion checks) for attributes in response body (json) has been included in tests
* Test execution report can be accessed under target/surefire-reports/emailable-report.html
* Execution commands to run test is as below:
	## Execute Tests
	Run below commands from CLI to run tests. 
    ## initiate build
        mvn clean
        mvn compile
    ## Run test
        mvn test
