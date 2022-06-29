package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Null value");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		return true;
	}
	
	public void addFront(E element) {
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = head.next;
		newNode.prev = newNode.next.prev;
		newNode.next.prev = newNode;
		head.next = newNode;
		size++;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index OOB");
		}
		
		LLNode<E> currNode = head.next;
		while (index > 0) {
			currNode = currNode.next;
			index--;
		}
		return currNode.data;
	}
	


	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Null value");
		}
		
		LLNode<E> prevIndexNode = head;
		while (index > 0) {
			prevIndexNode = prevIndexNode.next;
			index--;
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = prevIndexNode.next;
		prevIndexNode.next = newNode;
		newNode.next.prev = newNode;
		newNode.prev = prevIndexNode;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> targetNode = head;
		for (int i = 0; i <= index; i++) {
			targetNode = targetNode.next;
		}
		targetNode.prev.next = targetNode.next;
		targetNode.next.prev = targetNode.prev;
		size--;
		return targetNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index OOB");
		}
		if (element == null) {
			throw new NullPointerException("NPE");
		}
		
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		n.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
