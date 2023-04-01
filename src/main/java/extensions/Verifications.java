package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;
import java.util.Objects;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Picked Element Text")
    public static void verifyPickedElementText(WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        wait.until(ExpectedConditions.visibilityOf(elem2));
        assertEquals(elem1.getText(), elem2.getText());
    }

    @Step("Verify Picked Element Value with Text")
    public static void verifyPickedElementValueToText(WebElement elem1, WebElement elem2, String value) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        wait.until(ExpectedConditions.visibilityOf(elem2));
        assertEquals(elem1.getText(), elem2.getAttribute(value));
    }

    @Step("Verify Text In Element Is Not Equal to Given String")
    public static void verifyTextInElementIsNotEquals(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertNotEquals(elem.getText(), "0", "Error: Calories will not be burned for this type of exercise");
    }

    @Step("Verify Visibility of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry, " + elem.getText() + " is not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName) {
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".PNG");
        } catch (FindFailed e) {
            System.out.println("Error Comparing Image file: " + e);
            fail("Error Comparing Image File: " + e);
        }
    }

    @Step("Verify Element Displayed")
    public static void existenceOfElement(List<WebElement> elements, WebElement element, WebElement elemLink) {
        if (!(elements.size() > 1))
            try {
                if (Objects.equals(element.getText(), "No results found.")) //element = element = myfitnesspalSearchResult.text_NoResults
                    assertTrue(false, "Fail: No results found");

            } catch (NoSuchElementException e) {
                if (elemLink.isDisplayed()) // //elemLink = myfitnesspalSearchResult.link_searchResult
                    assertTrue(true);
                else
                    fail("Unknown Element");
            }
        else
            assertTrue(true);
    }

    @Step("Verify Element Not Displayed")
    public static void nonexistenceOfElement(List<WebElement> elements, WebElement element, WebElement elemLink) {
        try {
            if (!(elements.size() > 1)){
                assertEquals(element.getText(), "No results found."); // element = myfitnesspalSearchResult.text_NoResults
                // Should go to catch
            }
            else
                fail("Exercise is Displayed");
        }
        catch (TimeoutException | NoSuchElementException e){
            if(elemLink.isDisplayed()) //elemLink = myfitnesspalSearchResult.link_searchResult
                fail("Exercise is Displayed");
        }
    }

    @Step("Verify text against text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify number against number")
    public static void verifyNumber(int actual, int expected){
        assertEquals(actual, expected);
    }

    @Step("Verify Element Not Displayed for TodoList")
    public static void nonexistenceOfElementTodoList(List<WebElement> taskList, List<WebElement> taskNames, WebElement completedTask) {
        for (int i = 0; i < taskList.size(); i++) {
            try {
                assertNotEquals(taskNames.get(i), completedTask, "Failed! Completed Task Exist");
            } catch (NoSuchElementException e) {
                //Completed Task Exist
            }

        }
    }
}