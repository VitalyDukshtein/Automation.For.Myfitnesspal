package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: Add new task to the list")
    public static void addNewTask(String taskName){
        UIActions.updateText(todoMain.txt_createTask, taskName);
        UIActions.insertKey(todoMain.txt_createTask, Keys.RETURN);
    }

    @Step("Business Flow: Count and return number of tasks in list")
    public static int getNumberOfTasks(){
        return todoMain.list_tasks.size();
    }

    @Step("Business Flow: Clear all tasks from the list")
    public static void emptyList(){
        for (int i = 0; i < getNumberOfTasks(); i++) {
            UIActions.mouseHover(todoMain.btn_deleteTask);
        }
    }

    @Step("Business Flow: Complete task")
    public static void completeTask(String taskName){
        for (int i = 0; i < getNumberOfTasks(); i ++){
            if (taskName.equals(todoMain.list_taskNames.get(i).getText())) {
                UIActions.mouseHover(todoMain.btnList_completeTask.get(i));
            }
        }
    }
    @Step("Business Flow: Clear all Completed tasks from the list")
    public static void clearCompletedTasks(){
        for (int i = 0; i < todoMain.list_tasks.size(); i++) {
            if (todoMain.list_taskNames.get(i).equals(todoMain.txt_completedTask))
                UIActions.mouseHover(todoMain.btnList_deleteTask.get(i));
        }
    }

}
