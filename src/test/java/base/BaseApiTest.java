package base;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.given;

public class BaseApiTest {

    @BeforeTest
    public void setUpURIApi(ITestContext iTestContext) {
        RestAssured.baseURI = "https://yaninalondon.testmo.net";


        RestAssured.requestSpecification = given()
                //.auth().preemptive().basic(ReadProperties.email(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("Authorization",ReadProperties.token());

    }


}
