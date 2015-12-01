package Action;
import java.util.ArrayList;

import model.Task;

public class TaskOperation {
	public static ArrayList<Task> taskList = new ArrayList<Task>();
	
	public static void deleteTask() {
		
	}
	
	public static void pauseTask() {
		
	}
	
	public static void addTask(Task task) {
		taskList.add(task);
	}
	
	public static void runTask() {
		
	}
	
	public static void getTask() {
		
	}
	
	public static int size() {
		return taskList.size();
	}
}
