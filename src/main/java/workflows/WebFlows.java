package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import utilities.CommonOps;

import java.util.List;


public class WebFlows extends CommonOps {

    @Step("Business Flow: Login to MyFitnessPal WebApp")
    public static void login(String user, String pass){
        UIActions.updateText(myfitnesspalLoginPageWeb.txt_userEmail, user);
        UIActions.updateText(myfitnesspalLoginPageWeb.txt_userPassword, pass);
        closeCookiePopUp();
        UIActions.click(myfitnesspalLoginPageWeb.btn_loginWebApp);
    }

    @Step("Business Flow: Login to MyFitnessPal WebApp with DB Credentials")
    public static void loginDB(){
        String query = "SELECT email, password FROM Users WHERE id = '3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(myfitnesspalLoginPageWeb.txt_userEmail, cred.get(0));
        UIActions.updateText(myfitnesspalLoginPageWeb.txt_userPassword, cred.get(1));
        closeCookiePopUp();
        UIActions.click(myfitnesspalLoginPageWeb.btn_loginWebApp);
    }

    @Step("Business Flow: Input Exercise")
    public static void enterExercise(String exerciseName){
        UIActions.updateText(myfitnesspalSearchInput.txt_searchInput, exerciseName);
        UIActions.click(myfitnesspalsearch.btn_search);
        UIActions.click(myfitnesspalSearchResult.link_searchResult);
    }
    @Step("Business Flow: Insert Exercise Details")
    public static void insertExerciseDetails(String exerciseTimeMin, String yourWeight){
        UIActions.updateDropDown(myfitnesspalburnedCalories.list_weightUnit, "Kilograms");
        UIActions.clearText(myfitnesspalburnedCalories.txt_weightInput);
        UIActions.updateText(myfitnesspalburnedCalories.txt_weightInput, yourWeight);
        UIActions.updateText(myfitnesspalburnedCalories.txt_exerciseTimeInMinutes, exerciseTimeMin);
    }

    @Step("Business Flow: Insert Exercise Details")
    public static void chooseExerciseDetails(String exerciseTimeMin, String yourWeight){
        UIActions.clearText(myfitnesspalburnedCalories.txt_weightInput);
        UIActions.updateText(myfitnesspalburnedCalories.txt_weightInput, yourWeight);
        UIActions.updateText(myfitnesspalburnedCalories.txt_exerciseTimeInMinutes, exerciseTimeMin);
    }

    @Step("Business Flow: Choose Exercise From A List")
    public static void SelectExerciseFromDropDownList(String exerciseName){
        UIActions.click(myfitnesspalexerciseSelect.list_exerciseClick);

        for (int i = 0; i < myfitnesspalexerciseSelect.list_exercisesOptions.size(); i++){
            if (myfitnesspalexerciseSelect.list_exercisesOptions.get(i).getText().equalsIgnoreCase(exerciseName)) {
                myfitnesspalexerciseSelect.list_exercisesOptions.get(i).click();
                break;
            }
        }
    }

    @Step("Business Flow: Choose Wight Unit From A List")
    public static void SelectWeightUnitFromDropDownList(String unitName){
        UIActions.click(myfitnesspalburnedCalories.list_weightUnit);

        for(int i = 0; i < myfitnesspalburnedCalories.list_unitOptions.size(); i++){
            if (myfitnesspalburnedCalories.list_unitOptions.get(i).getText().equalsIgnoreCase(unitName)){
                myfitnesspalburnedCalories.list_unitOptions.get(i).click();
                break;
            }
        }
    }


    @Step("Business Flow: Search and Verify Exercise")
    public static void SearchAndVerifyExercise(String exerciseName, String shouldExists) {
        UIActions.updateText(myfitnesspalSearchInput.txt_searchInput, exerciseName);
        UIActions.click(myfitnesspalsearch.btn_search);
        if(shouldExists.equalsIgnoreCase("exists"))
            Verifications.existenceOfElement(myfitnesspalSearchResult.rows_searchResults, myfitnesspalSearchResult.text_NoResults,
                    myfitnesspalSearchResult.link_searchResult);
        else if(shouldExists.equalsIgnoreCase("Not-exist"))
            Verifications.nonexistenceOfElement(myfitnesspalSearchResult.rows_searchResults, myfitnesspalSearchResult.text_NoResults,
                    myfitnesspalSearchResult.link_searchResult);
        else
            throw new RuntimeException("Invalid Expected Output in Data Driven testing, Should be exists or not-exist");
    }

    public static void closeCookiePopUp() {
        try {
            driver.switchTo().frame(myfitnesspalLoginPageWeb.cookie_iframe);
            UIActions.click(myfitnesspalLoginPageWeb.btn_closeCookie);
            driver.switchTo().defaultContent();
        }
        catch (NoSuchElementException e){
            // In case Cookie Popup doesn't appear
        }
    }
}
