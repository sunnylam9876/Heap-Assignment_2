/**
 * 
 */
package assignment_2_package;

/**
 * 
 */
public class MaxHeap<T extends Comparable<? super T>> implements HeapInterface<T> {
	private T[] heap;	//ignore heap[0]
	private int lastIndex;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 20;
	private static final int MAX_CAPACITY = 1000;
	
	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}
	
		
	public MaxHeap(int initialCapacity) {
		// check initial capacity
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else {
			checkCapacity(initialCapacity);			
		}
		
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
	      heap = tempHeap;
	      lastIndex = 0;
	      integrityOK = true;

	}
	
	public MaxHeap(T[] entries) {
	   this(entries.length); // Call other constructor
	   lastIndex = entries.length;	  

	   // Copy given array to data field
	   for (int index = 0; index < entries.length; index++)
	      heap[index + 1] = entries[index];

	   // Create heap
	   for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
	      reheap(rootIndex);
	}

	
	public T getMax() {
		// ?? checkIntegrity();
		T root = null;
		if (!isEmpty())
			root = heap[1];
		return root;
	}
	
	public boolean isEmpty() {
		return lastIndex < 1;
	}
	
	public int getSize() {
		return lastIndex;
	}
	
	public void add(T newEntry) {
		// ? checkIntegrity();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}
		
		heap[newIndex] = newEntry;
		lastIndex++;
		// ? ensureCapacity();
	}
	
	public T removeMax() {
		// ? checkIntegrity();
		T root = null;
		
		if (!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
	}
	
	public void clear() {
		// ? checkIntegrity();
		while (lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;
	}
	
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Heap size exceeds maximum capacity");
		}
	}
	
	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;
		
		while(!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;

			if ( (rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0){
		         largerChildIndex = rightChildIndex;
		    } 

			if (orphan.compareTo(heap[largerChildIndex]) < 0){
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
			}
			else
				done = true;
		}
		heap[rootIndex] = orphan;
	}
}
