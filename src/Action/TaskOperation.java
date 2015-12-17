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
		System.out.println("hahahahahahahahhaha");
		taskList.add(task);
//		Thread thread = new Thread(task);
//		System.out.println(task.getTaskName() + " BEGIN!");
//		thread.start();
	}
	
	public static void runTask() {
		
	}
	
	public static void getTask() {
		
	}
	
	public static int size() {
		return taskList.size();
	}
}
