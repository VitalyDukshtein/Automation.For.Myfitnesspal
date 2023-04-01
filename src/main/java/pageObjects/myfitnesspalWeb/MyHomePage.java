package pageObjects.myfitnesspalWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyHomePage {

    @FindBy(how = How.XPATH, using = "//h1[@data-testid='label-your-daily-summary']")
    public WebElement txt_homeHeader;
}
