package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.myfitnesspalMobile.IntroPage;
import pageObjects.myfitnesspalMobile.LoginPage;
import pageObjects.myfitnesspalMobile.SearchResultsPage;
import pageObjects.myfitnesspalWeb.LoginPageWeb;
import pageObjects.myfitnesspalWeb.MyHomePage;

public class ManagePages extends Base {

    public static void initMyfitnesspalWeb(){

        myfitnesspalMain = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.MainPage.class);
        myfitnesspalSearchInput = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.SearchExercisePage.class);
        myfitnesspalsearch = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.SearchExercisePage.class);
        myfitnesspalSearchResult = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.MatchingExercisesPage.class);
        myfitnesspalexercisesName = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.CaloriesBurnedPage.class);
        myfitnesspalburnedCalories = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.CaloriesBurnedPage.class);
        myfitnesspalweightInput = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.CaloriesBurnedPage.class);
        myfitnesspalweightUnit = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.CaloriesBurnedPage.class);
        myfitnesspalexerciseTimeInMinutes = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.CaloriesBurnedPage.class);
        myfitnesspalexerciseSelect = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.ChooseExercisePage.class);
        myfitnesspalalphabet = PageFactory.initElements(driver, pageObjects.myfitnesspalWeb.AlphabetPage.class);
        myfitnesspalLoginPageWeb = PageFactory.initElements(driver, LoginPageWeb.class);
        myfitnesspalMyHomePage = PageFactory.initElements(driver, MyHomePage.class);
    }

    public static void initMyfitnesspalMobile(){

        myfitnesspalDashboardPage = new pageObjects.myfitnesspalMobile.DashboardPage(mobileDriver);
        myfitnesspalintroPage = new IntroPage(mobileDriver);
        myfitnesspalloginPage = new LoginPage(mobileDriver);
        myfitnesspalSearchResultsPage = new SearchResultsPage(mobileDriver);

    }

    public static void initToDo(){
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
