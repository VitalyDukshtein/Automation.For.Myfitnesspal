package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class MyfitnesspalWebDB extends CommonOps {

    @Test(description = "Test01 - Login to MyFitnesspal with DB Credentials")
    @Description("This test login with DB Credentials and verifies the main header")
    public void test01_LoginDBAndVerifyCorrectPage(){
        WebFlows.loginDB();
        Verifications.verifyTextInElement(myfitnesspalMyHomePage.txt_homeHeader,"Your Daily Summary");
    }

}
