package tests.api;

import base.BaseApiTest;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseApiTest {

    Gson gson = new Gson();

    @Test
    public void testRun(){
        given()
                .get(Endpoints.GET_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }


}
