package pageObjects.myfitnesspalWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CaloriesBurnedPage {
    @FindBy(how = How.CSS, using = "span[class='MuiTypography-root MuiTypography-Body/Bold/LG css-vzdhuf']")
    public WebElement txt_exercisesName;

    @FindBy(how = How.ID, using = "mui-1")
    public WebElement txt_weightInput;

    @FindBy(how = How.CSS, using = "div[class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary  css-1fo2ctb']")
    public WebElement list_weightUnit;

    @FindBy(how = How.CSS, using = "li[class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-vqszci']")
    public List<WebElement> list_unitOptions;

    @FindBy(how = How.ID, using = "mui-2")
    public WebElement txt_exerciseTimeInMinutes;

    @FindBy(how = How.CSS, using = "span[data-testid='result']")
    public WebElement output_burnedCalories;
}
