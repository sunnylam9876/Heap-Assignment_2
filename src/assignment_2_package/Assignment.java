/**
 * 
 */
package assignment_2_package;

/**
 * 
 */
public class Assignment implements Comparable<Assignment> {
	private String course;
	private String task;
	private String dueDate;
	
	public Assignment(String course, String task, String dueDate) {
		super();
		this.course = course;
		this.task = task;
		this.dueDate = dueDate;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	@Override
	public int compareTo(Assignment other) {
		// Compare assignments based on due dates
		// Earlier due dates have higher priority
		
		// multiply the value by -1 so that the order is reversed		
		return this.dueDate.compareTo(other.dueDate) * -1;	
	}
	
	@Override
	public String toString() {
		return "Course: " + course + "; Task: " + task + "; Due Date: " + dueDate;
	}
	
}
