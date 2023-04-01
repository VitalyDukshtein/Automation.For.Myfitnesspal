package pageObjects.myfitnesspalMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardPage {

    private AppiumDriver mobileDriver;

    public DashboardPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "textView")
    public AndroidElement txt_foodTypeSearch;

    @AndroidFindBy(className = "android.view.View")
    public AndroidElement btn_notificationBell;

    @AndroidFindBy(id = "action_diary")
    public AndroidElement btn_diary;

    @AndroidFindBy(id = "action_newsfeed")
    public AndroidElement btn_newsfeed;

    @AndroidFindBy(id = "action_plans")
    public AndroidElement btn_plans;

    @AndroidFindBy(id = "action_more")
    public AndroidElement btn_menu;

}
