/**
 * 
 */
package assignment_2_package;
import java.util.Scanner;

/**
 * 
 */
public class App {
	public static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int userInput;
		
		while (true) {
			System.out.println("\nPlease input your selection:");
			System.out.println("1. Part b: Find the k-th largest value in a collection of n values");
			System.out.println("2. Part c: Assignment task using priority queue");
			System.out.println("3. Exit the program");
			System.out.print("Enter your choice (1 / 2 / 3): ");
			scanner = new Scanner(System.in);
			userInput = scanner.nextInt();
			scanner.nextLine();		// Consume any leftover newline to avoid input error
			
			switch (userInput) {
			case 1:
				find_k_largest();		// Call the function for part b: find the k-th largest value
				scanner.nextLine();		// Consume any leftover newline to avoid input error
				break;
				
			case 2:
				assignmentApp();		// Call the function to part c: Assignment task
				break;
				
			case 3:
				scanner.close();		// Close scanner resources
				return;
				
			default:
                System.out.println("Invalid input. Please try again.\n");
			}
		} 
	}
	
	private static void find_k_largest() {
		// Read n and k from the user
        System.out.print("Enter the number of values (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k (0 < k < n): ");
        int k = scanner.nextInt();
        scanner.nextLine();		// Consume any leftover newline to avoid input error
        
        // Create a MaxHeap instance
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        // Read n values from the user and add them to the MaxHeap
        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            maxHeap.add(value);
        }

        // Remove the k-1 largest values
        for (int i = 0; i < k - 1; i++) {
            maxHeap.removeMax();
        }

        // The k-th largest value is now at the root of the MaxHeap
        int kthLargest = maxHeap.getMax();

        System.out.println("The " + k + "th largest value is: " + kthLargest + "\n");
        
	}
	
	private static void assignmentApp() {
		MaxHeap<Assignment> assignmentHeap = new MaxHeap<>();
		
		while (true) {
            System.out.println("\nAssignment Menu:");
            System.out.println("1. Add Assignment");
            System.out.println("2. Remove Assignment with Earliest Due Date");
            System.out.println("3. View Assignment with Earliest Due Date");
            System.out.println("4. View All Assignments");
            System.out.println("5. Exit this part");
            System.out.print("Enter your choice: (1 - 5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    // Add Assignment
                    System.out.print("Enter course name: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    String dueDate = scanner.nextLine();
                    Assignment newAssignment = new Assignment(course, task, dueDate);
                    assignmentHeap.add(newAssignment);
                    System.out.println("Assignment added successfully.\n");
                    break;
                case 2:
                    // Remove Assignment with Earliest Due Date
                    if (!assignmentHeap.isEmpty()) {
                        Assignment removedAssignment = assignmentHeap.removeMax();
                        System.out.println("Removed Assignment with Earliest Due Date:");
                        System.out.println(removedAssignment);
                    } else {
                        System.out.println("No assignments to remove.\n");
                    }
                    break;
                case 3:
                    // View Assignment with Earliest Due Date
                    if (!assignmentHeap.isEmpty()) {
                        Assignment earliestAssignment = assignmentHeap.getMax();
                        System.out.println("Assignment with Earliest Due Date:");
                        System.out.println(earliestAssignment);
                    } else {
                        System.out.println("No assignments available.\n");
                    }
                    break;
                case 4:
                    // View All Assignments
                    if (!assignmentHeap.isEmpty()) {
                        System.out.println("All Assignments:");
                        for (Assignment assignment : assignmentHeap.toArray(new Assignment[0])) {
                            System.out.println(assignment);
                        }
                    } else {
                        System.out.println("No assignments available.\n");
                    }
                    break;
                case 5:
                    // Exit the program
                	return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

}
