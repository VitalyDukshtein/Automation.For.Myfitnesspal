package pageObjects.myfitnesspalWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageWeb {

    @FindBy(how = How.ID, using = "email")
    public WebElement txt_userEmail;

    @FindBy(how = How.ID, using = "password")
    public WebElement txt_userPassword;

    @FindBy(how = How.XPATH, using = "//span[@class='MuiTypography-root MuiTypography-button1 css-b9fb38']")
    public WebElement btn_loginWebApp;

    @FindBy(how = How.ID, using = "sp_message_iframe_760094")
    public WebElement cookie_iframe;

    @FindBy(how = How.XPATH, using = "//button[@title='X']")
    public WebElement btn_closeCookie;
}
