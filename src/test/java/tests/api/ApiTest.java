package tests.api;

import adapters.ProjectAdapter;
import base.BaseApiTest;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@Feature("API TESTS")

public class ApiTest extends BaseApiTest {

    Gson gson = new Gson();

    @Test(description = "Получение пользователя")
    public void testRun() {
        given()
                .get(Endpoints.GET_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test(description = "Получение несуществующего проекта")
    @Issue("BUG-3322")
    public void testFindNonExistentProject(){
        given()
                .get(Endpoints.GET_PROJECTS_Negative)
                .then()
                .log().status()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test(description = "Получение всех проектов")
    public void testProject() {
        given()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .and().body("result.name", hasItems("ProjectForAPI"));
    }

    @Test(description = "Получение рана")
    public void testGetRuns(){
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