package tests.api;

import adapters.ProjectAdapter;
import base.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest extends BaseApiTest {

    @Test(description = "еще не придумал")
    public void testRun() {
        given()
                .get(Endpoints.GET_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }


    @Test(description = "Get все проекты, проверка в теле есть проект name=ProjectForAPI")
    public void testProject() {
        given()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .and().body("result.name", hasItems("ProjectForAPI"));
    }

    @Test
    public void test3(){
        given()
                .get("/api/v1/automation/runs/1")
                .then().log().body();
    }

    /**
     * JSONPath
     * $.result[?(@.name=='ProjectForAPI')].id,name = выбрать из всех Проектов {name, id}
     */

    @Test(description = "Создание нового RunTest и закрытие")
    public void testTestRunAndTestClose() {
        int newRunTest = new ProjectAdapter().createRunTest();

        given()
                .body(String.format("{\n" +
                        "    \"measure_elapsed\": true\n" +
                        "}"))
                .when()
                .post("/api/v1/automation/runs/" + newRunTest + "/complete")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }


}