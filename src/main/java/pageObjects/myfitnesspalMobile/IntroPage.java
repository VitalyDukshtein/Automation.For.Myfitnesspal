package pageObjects.myfitnesspalMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class IntroPage {

    private AppiumDriver mobileDriver;

    public IntroPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy (id = "buttonSignUp")
    public AndroidElement btn_signUp;

    @AndroidFindBy (id = "buttonLogIn")
    public AndroidElement btn_logIn;
}
