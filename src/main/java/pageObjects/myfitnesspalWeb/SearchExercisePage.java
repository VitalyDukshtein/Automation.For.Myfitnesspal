package pageObjects.myfitnesspalWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchExercisePage {
    @FindBy(how = How.CSS, using = "input[name='searchInput']")
    public WebElement txt_searchInput;

    @FindBy(how = How.CSS, using = "svg[data-testid='SearchIcon']")
    public WebElement btn_search;
}
