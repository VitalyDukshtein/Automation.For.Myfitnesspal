package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Login to MyFitnessPal Mobile App")
    public static void login(String email, String password){
        MobileActions.tapOnBackKey();
        MobileActions.tap(myfitnesspalintroPage.btn_logIn);
        MobileActions.clearText(myfitnesspalloginPage.txt_email_address);
        MobileActions.updateText(myfitnesspalloginPage.txt_email_address, email);
        MobileActions.updateText(myfitnesspalloginPage.txt_password, password);
        MobileActions.tap(myfitnesspalloginPage.btn_login);
    }

    @Step("Business Flow: Search food")
    public static void SearchFood(String foodName){
        MobileActions.tap(myfitnesspalDashboardPage.txt_foodTypeSearch);
        MobileActions.updateText(myfitnesspalSearchResultsPage.txt_searchField, foodName);
        MobileActions.tapOnEnterKey();
    }

    @Step("Business Flow: Add food to the diary")
    public static void addFood(String foodName){
        MobileActions.updateText(myfitnesspalDashboardPage.txt_foodTypeSearch, foodName);
        MobileActions.enter(myfitnesspalDashboardPage.txt_foodTypeSearch);
        MobileActions.tap(myfitnesspalSearchResultsPage.btn_addFood);
    }

}
