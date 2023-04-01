package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.myfitnesspalMobile.DashboardPage;
import pageObjects.myfitnesspalMobile.*;
import pageObjects.myfitnesspalMobile.LoginPage;
import pageObjects.myfitnesspalWeb.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    // General
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static JavascriptExecutor js;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    // Web
    protected static WebDriver driver; // Work also for electron

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();


    // Page Objects - Web
    protected static MainPage myfitnesspalMain;
    protected static SearchExercisePage myfitnesspalSearchInput;
    protected static SearchExercisePage myfitnesspalsearch;
    protected static MatchingExercisesPage myfitnesspalSearchResult;
    protected static CaloriesBurnedPage myfitnesspalexercisesName;
    protected static CaloriesBurnedPage myfitnesspalburnedCalories;
    protected static CaloriesBurnedPage myfitnesspalweightInput;
    protected static CaloriesBurnedPage myfitnesspalweightUnit;
    protected static CaloriesBurnedPage myfitnesspalexerciseTimeInMinutes;
    protected static ChooseExercisePage myfitnesspalexerciseSelect;
    protected static AlphabetPage myfitnesspalalphabet;
    protected static LoginPageWeb myfitnesspalLoginPageWeb;

    // Page Objects - Mobile
    protected static DashboardPage myfitnesspalDashboardPage;
    protected static IntroPage myfitnesspalintroPage;
    protected static LoginPage myfitnesspalloginPage;
    protected static SearchResultsPage myfitnesspalSearchResultsPage;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;
    protected static MyHomePage myfitnesspalMyHomePage;

    // Page Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;

    // Page Objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;
}
