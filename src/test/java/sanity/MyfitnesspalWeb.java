package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class MyfitnesspalWeb extends CommonOps {

    @Test (description = "Test01 - Verify Page Header")
    @Description("This test verifies the main header")
    public void test01_VerifyCorrectPage(){
        Verifications.verifyTextInElement(myfitnesspalMain.head_mainPage,"Calories Burned From Exercise");
    }


    @Test (description = "Test02 - Verify Picked Exercises Presented")
    @Description("This test verifies that the picked exercise is presented")
    public void test02_VerifyPickedExercisesPresented(){
        WebFlows.enterExercise("Bowling");
        Verifications.verifyPickedElementText(myfitnesspalSearchResult.link_searchResult, myfitnesspalburnedCalories.txt_exercisesName);
    }

    @Test (description = "Test03 - Verify Calories Burned Is Presented For Exercises")
    @Description("This test verifies the burned calories is presented for an exercise")
    public void test03_VerifyCaloriesBurnedIsPresentedForExercises(){
        WebFlows.SelectExerciseFromDropDownList("Soccer");
        UIActions.click(myfitnesspalexerciseSelect.link_exercisesPick);
        WebFlows.SelectWeightUnitFromDropDownList("Kilograms");
        WebFlows.chooseExerciseDetails("60", "65");
        Verifications.verifyTextInElementIsNotEquals(myfitnesspalburnedCalories.output_burnedCalories);
    }

    @Test (description = "Test04 - Verify Alphabet Database")
    @Description("This test verifies that all the alphabet database is presented (using soft assertion)")
    public void test04_verifyAlphabetDatabase(){
        Verifications.visibilityOfElements(myfitnesspalalphabet.list_alphabet);
    }


    @Test (description = "Test05 - Verify Logo Image")
    @Description("This test verifies logo image using Sikuli tool")
    public void test05_verifyLogoImage() {
        Verifications.visualElement("myfitnesspalLogo");
    }


    @Test (description = "Test06 - Search Exercises", dataProvider = "data-provider-exercises", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test searching exercises in a table using DDT")
    public void test06_searchExercises(String exerciseName, String shouldExist){
        WebFlows.SearchAndVerifyExercise(exerciseName, shouldExist);
    }
}