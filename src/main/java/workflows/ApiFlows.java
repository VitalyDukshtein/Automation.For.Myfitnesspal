package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Student Property")
    public static String getStudentProperty(String jPath) {
        response = ApiActions.get("/student/list");
       // response.prettyPrint();
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Add new student to the list")
    public static void postStudent(String firstName, String lastName, String email, String programme) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        ApiActions.post(params, "/student");
    }

    @Step("Business Flow: Update Existing student to the list")
    public static void updateStudent(String firstName, String lastName, String email,String programme, String id){
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        ApiActions.put(params, "/student/" + id);
    }

    @Step("Business Flow: Delete Existing student from the list")
    public static void deleteStudent(String id) {
        ApiActions.delete(id);
    }

    @Step("Business Flow: Count students in the list")
    public static int countStudent(String value) {
        return ApiActions.inputToList(value);
    }
}
