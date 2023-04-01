package pageObjects.myfitnesspalWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MatchingExercisesPage {

    @FindBy(how = How.CSS, using = "span[class='MuiTypography-root MuiTypography-Body/Regular/LG css-12dz3fe']")
    public WebElement link_searchResult;

    @FindBy(how = How.CSS, using = "span[class='MuiTypography-root MuiTypography-Body/Regular/LG css-12dz3fe']")
    public List<WebElement> rows_searchResults;

    @FindBy(how = How.CSS, using = "span[class='MuiTypography-root MuiTypography-Body/Regular/LG css-tt6bcq']")
    public WebElement text_NoResults;
}

