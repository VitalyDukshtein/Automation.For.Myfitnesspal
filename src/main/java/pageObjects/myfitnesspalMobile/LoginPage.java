package pageObjects.myfitnesspalMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    private AppiumDriver mobileDriver;

    public LoginPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "email_address_edit")
    public AndroidElement txt_email_address;

    @AndroidFindBy(id = "password_edit")
    public AndroidElement txt_password;

    @AndroidFindBy(id = "login_button")
    public AndroidElement btn_login;
}
