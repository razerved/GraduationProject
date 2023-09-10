package base;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.hc.core5.http2.impl.nio.HttpProtocolNegotiator;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.core.util.AuthorizationProvider;
import org.bouncycastle.est.HttpAuth;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
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


    /*@AfterTest
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()){
            System.out.println("Make screenshot");
        }
    }*/

}
