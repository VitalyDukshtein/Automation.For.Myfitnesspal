package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01 - Add and Verify New Task")
    @Description("This test adds a new task and verifies that the task was added to the list")
    public void test01_addAndVerifyNewTask(){
        int numberOfTasksOnStart = ElectronFlows.getNumberOfTasks();
        ElectronFlows.addNewTask("Learn Stock Market");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), numberOfTasksOnStart + 1);
    }

    @Test(description = "Test02 - Remove completed tasks and Verify")
    @Description("The test adds four new tasks, completes two, removes two, and verifies that the remain tasks are open.")
    public void test02_deleteCompletedTasksAndVerify(){
        ElectronFlows.addNewTask("Learn Crypto");
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Surfing");
        ElectronFlows.completeTask("Learn Java");
        ElectronFlows.completeTask("Learn Surfing");
        ElectronFlows.clearCompletedTasks();
        Verifications.nonexistenceOfElementTodoList(todoMain.list_tasks, todoMain.list_taskNames, todoMain.txt_completedTask);
    }

}
