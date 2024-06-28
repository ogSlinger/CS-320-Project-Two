import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	
	static private TaskService TaskService = new TaskService();
	static private Task goodTask = new Task();
	static private Task duplicateTask = new Task();

	@BeforeAll
	static void setup() {
		goodTask.setId("Good ID");
		goodTask.setName("Good Name");
		goodTask.setDescription("Good Description");
		
		duplicateTask.setId("Good ID");
		duplicateTask.setName("Good Name Clone");
		duplicateTask.setDescription("Good Description Clone");
	}
	
	@Test
	void addTest() {
		assertTrue(TaskService.addTask(goodTask));
		assertFalse(TaskService.addTask(duplicateTask));
	}
	
	@Test
	void updateTaskTest() {
		//Task service cannot update ID as there are no methods for it
		assertTrue(TaskService.updateTaskName("Good ID", "Good Name 2"));
		assertTrue(TaskService.updateTaskDescription("Good ID", "Good Description 2"));
	}
	
	@Test
	void deleteTaskTest() {
		assertTrue(TaskService.deleteTask("Good ID"));
		assertFalse(TaskService.deleteTask("Good ID"));
	}

}
