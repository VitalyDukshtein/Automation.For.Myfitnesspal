package pageObjects.myfitnesspalWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ChooseExercisePage {

    @FindBy(how = How.CSS, using = "div[aria-labelledby='exercise']")
    public WebElement list_exerciseClick;

    @FindBy(how = How.CSS, using = "li[class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1xzadq1']")
    public List<WebElement> list_exercisesOptions;

    @FindBy(how = How.CSS, using = "span[class='MuiTypography-root MuiTypography-Body/Regular/LG css-12dz3fe']")
    public WebElement link_exercisesPick;
}
