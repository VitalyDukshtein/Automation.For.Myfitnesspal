package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MyfitnesspalMobile extends CommonOps {

    @Test(description = "Test01 - Verify Search Results ")
    @Description("This test verifies the text in the search results")
    public void test01_VerifySearchResults(){
        MobileFlows.login(getData("UserName"), getData("Password"));
        MobileFlows.SearchFood("banana");
        Verifications.verifyTextInElement(myfitnesspalSearchResultsPage.txt_foodName, "Banana");
    }

}
