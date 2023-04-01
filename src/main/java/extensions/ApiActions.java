package extensions;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

import java.util.List;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
        response.prettyPrint();
        return response;
    }

    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data in Server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("Delete Data from Server")
    public static void delete(String id) {
        response = httpRequest.delete("/student/" + id);
        response.prettyPrint();
    }

    @Step("Input values to a List")
    public static int inputToList(String value){
        response = httpRequest.get("/student/list");
        jp = response.jsonPath();
        List<String> allStudents = jp.getList(value);
        System.out.println(allStudents.size());
        return allStudents.size();
    }

}