package Action;

import java.util.ArrayList;

import model.Task;

public class TaskOperation {
	public static ArrayList<Task> taskList = new ArrayList<Task>();

	private static final int INIT = -1;
	private static final int RUNNING = 1;
	private static final int STOP = 2;
	private static final int PAUSE = 3;

	public static void deleteTask(int tid) {
		synchronized (taskList) {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getTid() == tid) {
					taskList.remove(i);
					break;
				}
			}
		}
	}

	public static void pauseTask(int tid) {
		synchronized (taskList) {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getTid() == tid) {
					taskList.get(i).setStatus(PAUSE);
					break;
				}
			}
		}
	}

	public static void addTask(Task task) {
		System.out.println("hahahahahahahahhaha");
		taskList.add(task);
		Thread thread = new Thread(task);
		System.out.println(task.getTaskName() + " BEGIN!");
		thread.start();
	}

	public static void runTask(int tid) {
		synchronized (taskList) {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getTid() == tid) {
					if (taskList.get(i).getStatus() == PAUSE) {
						taskList.get(i).setStatus(RUNNING);
						break;
					}
				}
			}
		}
	}

	public static Task getTask(int tid) {
		synchronized (taskList) {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskList.get(i).getTid() == tid) {
					return taskList.get(i);
				}
			}
		}
		return null;
	}

	public static int size() {
		return taskList.size();
	}
}
