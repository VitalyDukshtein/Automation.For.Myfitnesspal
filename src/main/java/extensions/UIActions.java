package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.List;

public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover on Element")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
    @Step("Clear Text from Element")
    public static void clearText(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }
    @Step("Scroll to Element")
    public static void scrollToElement(WebElement elem){
        js.executeScript("arguments[0].scrollIntoView(true);",elem);
    }
    @Step("Mouse Hover on Element")
    public static void mouseHover(WebElement elem1){
        actions.moveToElement(elem1).click().build().perform();
    }
    @Step("Insert Keyboard action")
    public static void insertKey(WebElement elem, Keys value){
        elem.sendKeys(value);
    }
}
