package adapters;

import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {
    public int createRunTest() {
        Response response = given()
                .body(String.format("{\n" +
                        "    \"name\": \"Run 1\",\n" +
                        "    \"source\": \"frontend\",\n" +
                        "    \"tags\": [\n" +
                        "        \"tag-a\",\n" +
                        "        \"tag-b\"\n" +
                        "    ],\n" +
                        "    \"artifacts\": [\n" +
                        "        {\n" +
                        "            \"name\": \"Artifact 1.png\",\n" +
                        "            \"url\": \"https://example.com/artifact1.png\",\n" +
                        "            \"mime_type\": \"image/png\",\n" +
                        "            \"size\": 1048576\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"fields\": [\n" +
                        "        {\n" +
                        "            \"name\": \"Field 1\",\n" +
                        "            \"type\": 4,\n" +
                        "            \"value\": \"..\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"links\": [\n" +
                        "        {\n" +
                        "            \"name\": \"Link 1\",\n" +
                        "            \"url\": \"https://example.com\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"))
                .when()
                .post("/api/v1/projects/1/automation/runs")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().response();
        int i = response.getBody().jsonPath().getInt("id");
        return i;
    }


    public int getIdProjectByName(String nameProject) {
        List<Project> projects = given()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .extract().body().jsonPath().getList("result",Project.class);
        int p = projects.stream().filter(x->x.getName().equals(nameProject)).findAny().get().getId();
        return p;
    }
}
