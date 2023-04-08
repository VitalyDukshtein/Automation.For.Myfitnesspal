package Helper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import workflows.ApiFlows;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:9000";

    @Test
    public void testingAPI(){
        RestAssured.baseURI = url;
        httpRequest = given();
        httpRequest.header("Content-Type", "application/json");

        // Get Request
        response = httpRequest.get("/student/list");

        // Post Request
/*        JSONObject params = new JSONObject();
        params.put("firstName", "Vito");
        params.put("lastName", "King");
        params.put("email", "vito4you@gmail.com");
        params.put("programme", "Engineering");

        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/student");*/

        // Put Request
       /* JSONObject params = new JSONObject();
        params.put("firstName", "Vito");
        params.put("lastName", "The King");
        params.put("email", "vito4you@gmail.com");
        params.put("programme", "Engineering");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put("/student/101");*/

        // Delete Request
      //  response = httpRequest.delete("/student/100");

        //response.prettyPrint();

     //   int num = 0;
        JsonPath jp = response.jsonPath();
        List<String> allStudents = jp.getList("email");
                //Collections.singletonList(jp.get("[" + num + "]").toString());
        System.out.println(allStudents.size());
       // System.out.println(jp.get("[" + num + "]").toString());


        //String num = ApiFlows.getStudentProperty("")
       // for(int i = 0; i < [].length; i++){

        }

    }

