package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import pageObjects.calculator.MainPage;
import workflows.ElectronFlows;
import workflows.WebFlows;

import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class CommonOps extends Base{

    /*
     #######################################################################################
     Method Name: getData
     Method Description: This method retrieves data from the XML configuration file
     Method Parameters: String
     Method Return: String
     #######################################################################################
     */
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }

        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /*
     #######################################################################################
     Method Name: initBrowser
     Method Description: This method starts the relevant web browser
     Method Parameters: String
     Method Return: -
     #######################################################################################
     */
    public static void initBrowser(String browserType){
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("edge"))
            driver = initEdgeDriver();
        else if (browserType.equalsIgnoreCase("opera"))
            driver = initOperaDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        if (platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
        else
            driver.get(getData("Loginurl"));
        ManagePages.initMyfitnesspalWeb();
    }

    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public static WebDriver initOperaDriver(){
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        return driver;
    }

    /*
     #######################################################################################
     Method Name: initMobile
     Method Description: This method starts the appium server for mobile
     Method Parameters: -
     Method Return: -
     #######################################################################################
     */
    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " + e);
        }
        ManagePages.initMyfitnesspalMobile();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));

    }
    /*
         #######################################################################################
         Method Name: initAPI
         Method Description: This method receives HTTP requests for API testing
         Method Parameters: -
         Method Return: -
         #######################################################################################
         */
    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = given();
    }

    /*
         #######################################################################################
         Method Name: initElectron
         Method Description: This method starts Electron driver
         Method Parameters: -
         Method Return: -
         #######################################################################################
         */
    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }

    /*
         #######################################################################################
         Method Name: initDesktop
         Method Description: This method starts appium server for desktop
         Method Parameters: -
         Method Return: -
         #######################################################################################
         */
    public static void initDesktop(){
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Can't Connect to Appium Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        platform = PlatformName;
        if(platform.equalsIgnoreCase("web") || platform.equalsIgnoreCase("webDB"))
            initBrowser(getData("BrowserName"));
            else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
            else if (platform.equalsIgnoreCase("api"))
            initAPI();
            else if (platform.equalsIgnoreCase("electron"))
            initElectron();
            else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
            else
                throw new RuntimeException("Invalid platform name");

        js = (JavascriptExecutor)driver;
        softAssert = new SoftAssert();
        screen = new Screen();
        if(platform.equalsIgnoreCase("webDB"))
            ManageDB.startConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
        if(platform.equalsIgnoreCase("desktop") || (platform.equalsIgnoreCase("mobile")) ||
                (platform.equalsIgnoreCase("api"))){
            //Do Nothing
        }
            else
                actions = new Actions(driver);
    }

    @AfterClass
    public void closeSession(){
        if(platform.equalsIgnoreCase("webDB"))
        ManageDB.endConnection();
        if(!platform.equalsIgnoreCase("api")){
            if(!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    @AfterMethod
    public void afterTest() {
        if(platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
        else if(platform.equalsIgnoreCase("electron"))
            ElectronFlows.emptyList();
    }

    @BeforeMethod
    public void beforeTest(Method method){
        if(!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(platform.equalsIgnoreCase("web"))
            WebFlows.closeCookiePopUp();
    }

}
