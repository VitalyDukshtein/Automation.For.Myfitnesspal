package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class StudentsAPI extends CommonOps {

    @Test(description = "Test 01 - Verify Student's Programme")
    @Description("This test verifies the programme of the first student in the list")
    public void test01_verifyStudentsProgramme() {
        Verifications.verifyText(ApiFlows.getStudentProperty("[0].programme"), "Financial Analysis");
    }

    @Test(description = "Test 02 - Add Student And Verify")
    @Description("This test adds a student and verifies it")
    public void test02_addStudentAndVerify() {
        ApiFlows.postStudent("Vito", "Scoot", "vito@gmail.com", "Automation" );
        Verifications.verifyText(ApiFlows.getStudentProperty("[100].programme"), "Automation");
    }

    @Test(description = "Test 03 - Update Student And Verify")
    @Description("This test updates student's programme and verifies it")
    public void test03_updateStudentAndVerify() {
        String id = ApiFlows.getStudentProperty("[100].id");
        ApiFlows.updateStudent("Vito", "Scoot", "vito@gmail.com","QA Automation", id);
        Verifications.verifyText(ApiFlows.getStudentProperty("[100].programme"), "QA Automation");
    }

    @Test(description = "Test 04 - Delete Student And Verify")
    @Description("This test deletes student from the list and verifies it")
    public void test04_deleteStudentAndVerify() {
        int studentNumber = ApiFlows.countStudent("email");
        String id = ApiFlows.getStudentProperty("[100].id");
        ApiFlows.deleteStudent(id);
        Verifications.verifyNumber(ApiFlows.countStudent("email"),studentNumber - 1);
    }
}