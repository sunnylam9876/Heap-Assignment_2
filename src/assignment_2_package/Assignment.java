/**
 * 
 */
package assignment_2_package;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



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
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate thisDate = LocalDate.parse(this.dueDate, formatter);
        LocalDate otherDate = LocalDate.parse(other.dueDate, formatter);
        return otherDate.compareTo(thisDate);
    }
	
	@Override
	public String toString() {
		return "Course: " + course + "; Task: " + task + "; Due Date: " + dueDate;
	}
	
}
