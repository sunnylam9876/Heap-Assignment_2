/**
 * 
 */
package assignment_2_package;

/**
 * 
 */
public interface HeapInterface<T> {
	public void add(T newEntry);
	public T removeMax();
	public T getMax();
	public boolean isEmpty();
	public int getSize();
	public void clear();
}
