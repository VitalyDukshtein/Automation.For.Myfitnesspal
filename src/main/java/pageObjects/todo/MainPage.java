package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CLASS_NAME, using = "input_b5pqF")
    public WebElement txt_createTask;

    @FindBy(how = How.CLASS_NAME, using = "taskWrapper_2u8dN")
    public List<WebElement> list_tasks;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_deleteTask;

    @FindBy(how = How.CLASS_NAME, using = "toggleIconsWrapper_2kpi8")
    public WebElement btn_completeTask;

    @FindBy(how = How.CSS, using = "label[class='label_5i8SP completed_bHv-Q']")
    public WebElement txt_completedTask;

    @FindBy(how = How.CLASS_NAME, using = "label_5i8SP")
    public List<WebElement> list_taskNames;

    @FindBy(how = How.CLASS_NAME, using = "toggleIconsWrapper_2kpi8")
    public List<WebElement> btnList_completeTask;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public List<WebElement> btnList_deleteTask;
}
