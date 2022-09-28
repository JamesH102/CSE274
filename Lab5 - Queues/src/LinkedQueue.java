import java.util.NoSuchElementException;/** * A class that implements the ADT queue by using a chain of linked nodes that * has references to the front and end of the chain. Adds will be after the last * node. Removes will be from the front node. *  * @author James Hering, CSE274, 28 September 2022 */public final class LinkedQueue<T> implements QueueInterface<T> {	private Node firstNode; // References node at front of queue	private Node lastNode; // References node at back of queue	private int size = 0; // Size of the linked queue	public LinkedQueue() {		firstNode = null;		lastNode = null;	} // end default constructor	public void add(T newEntry) {		Node temp = new Node(newEntry);		// Setting the new Node to both if the linked list is empty		if (firstNode == null) {			firstNode = temp;			lastNode = temp;		} else {			lastNode.next = temp;			lastNode = temp;		}		size++;	} // end enqueue	public T peek() {		if (isEmpty())			throw new NoSuchElementException();		else			return firstNode.data;	} // end getFront	public T remove() {		// Doesn't remove if the list is empty		if (this.size == 0) {			throw new NoSuchElementException(); // Might throw NoSuchElementException		} else if (size == 1) {			T frontData = peek();			clear();			return frontData;		} else {			T frontData = peek();			firstNode = firstNode.next;			size--;			return frontData;		}	} // end dequeue	public boolean isEmpty() {		return size == 0;	} // end isEmpty	public void clear() {		firstNode = null;		lastNode = null;		size = 0;	} // end clear	private class Node {		private T data;		private Node next;		private Node(T data) {			this.data = data;			this.next = null;		}	}}