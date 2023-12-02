/**
 * 
 */
package assignment_2_package;
import java.util.Scanner;

/**
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Read n and k from the user
        System.out.print("Enter the number of values (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k (1 <= k < n): ");
        int k = scanner.nextInt();

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

        // The kth largest value is now at the root of the MaxHeap
        int kthLargest = maxHeap.getMax();

        System.out.println("The " + k + "th largest value is: " + kthLargest);

        scanner.close();

	}

}
