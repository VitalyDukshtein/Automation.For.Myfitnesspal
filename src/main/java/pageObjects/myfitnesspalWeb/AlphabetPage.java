package pageObjects.myfitnesspalWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AlphabetPage {

    @FindBy(how = How.CSS, using = "a[class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css-93vv3d']")
    public List<WebElement> list_alphabet;

}
