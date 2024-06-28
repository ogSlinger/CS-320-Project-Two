import java.lang.String;
import java.util.Vector;

public class TaskService {
	public String id = new String();
	public String name = new String();
	public String description = new String();
	public Vector<Task> taskVector = new Vector<Task>();
	
	public boolean addTask(Task newTask) {
		if (!this.checkIdUniqueness(newTask) ||
				(newTask.getName().length() > 20 || newTask.getName().length() <= 0) ||
				(newTask.getDescription().length() > 50 || newTask.getDescription().length() <= 0)) {
			return false;
		}
		taskVector.add(newTask);
		return true;
	}
	
	private boolean checkIdUniqueness(Task newTask) {
		for (int i = 0; i < this.taskVector.size(); i++) {
			if (this.taskVector.get(i).getId().equals(newTask.getId())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean deleteTask(String id) {
		for (int i = 0; i < this.taskVector.size(); i++) {
			if (taskVector.get(i).getId().equals(id)) {
				taskVector.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateTaskName(String id, String content) {
		for (int i = 0; i < this.taskVector.size(); i++) {
			if (taskVector.get(i).getId().equals(id)) {
				taskVector.get(i).setName(content);
				return (taskVector.get(i).getName().equals(content)) ? true : false;
			}
		}
		return false;
	}
	
	public boolean updateTaskDescription(String id, String content) {
		for (int i = 0; i < this.taskVector.size(); i++) {
			if (taskVector.get(i).getId().equals(id)) {
				taskVector.get(i).setDescription(content);
				return (taskVector.get(i).getDescription().equals(content)) ? true : false;
			}
		}
		return false;
	}
}
