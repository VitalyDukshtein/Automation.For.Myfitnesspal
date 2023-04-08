package sanity;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import workflows.WebFlows;

import java.util.List;

public class TestForMySelf {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myfitnesspal.com/exercise/lookup");
    }

    @Test
    public void test01(){
        WebFlows.closeCookiePopUp();
        System.out.println(driver.findElement(By.id("calories_burned_description")).getAttribute("value"));
        //System.out.println(driver.findElement(By.className("main-title")).getText());
    }
   /* @Test
    public void test02(){
        List<WebElement> elems = driver.findElements(By.xpath("//div[@id='browse_by_name']/a"));
        for (WebElement elem : elems ) {
            System.out.println(elem.getText());
        }
    }

    @Test
    public void test03(){
        driver.findElement(By.id("search")).sendKeys("avi");
        driver.findElement(By.xpath("//*[@id='searchForm']/p/input[2]")).click();
        System.out.println(driver.findElement(By.xpath("//ul[@id='matching']/li")).getText());
    }*/

    /*
    @Test
    public void testForMe(){
        WebFlows.closeCookiePopUp();
        UIActions.click(myfitnesspalexerciseSelect.list_exerciseClick);
        System.out.println(myfitnesspalexerciseSelect.list_exercisesOptions.size());
        // WebFlows.SelectExerciseFromDropDownList("Soccer");
    }
    */

}
