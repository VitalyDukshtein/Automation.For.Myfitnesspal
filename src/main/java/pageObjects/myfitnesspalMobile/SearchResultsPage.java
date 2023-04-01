package pageObjects.myfitnesspalMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchResultsPage {

    private AppiumDriver mobileDriver;

    public SearchResultsPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @FindBy(id = "quickLogAddRemoveIcon")
    public AndroidElement btn_addFood;

    @FindBy(id = "text_primary")
    public AndroidElement txt_foodName;

    @FindBy(id = "searchEditText")
    public AndroidElement txt_searchField;
}
