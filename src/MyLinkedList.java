/*
 * Rishabh Patel
 * 03/03/2017
 * CMSC 256 - 001
 * Project - MyLinkedList
 * Class Description: Implements all of the abstract methods from the AbstractLinkedList class
 * and overrides them with exceptions and proper function.
 */
public class MyLinkedList<E> extends AbstractLinkedList<E>
{

	
	AbstractLinkedList<E> list;
	
/*	public MyLinkedList() {
		AbstractLinkedList<E> list = new AbstractLinkedList<String>();
	}*/
	 /*
	  * Removes the given element from this list, if it is present in the list.
	  * Returns true if the element was in the list and was removed.
	  */
	
	// This remove method behaves by always removing the element with the lowest index
	// when there are more than 1 instances of the element.
	 public boolean remove(E element)
	 {
		
		 if (contains(element) == true) // accesses the contains method to check if the element exists
		 {
			 int index = indexOf(element); // accesses the index of the element
			 Node nodeToRemove = getNodeAt(index); // accesses the node of an element and sets it equal to a variable
			 nodeToRemove.getPrevious().setNext(nodeToRemove.getNext()); // changes the head and tail references
			 nodeToRemove.getNext().setNext(nodeToRemove.getPrevious()); // changes the head and tail references
			 
			 return true; // returns true
		 }
		 return false; // else, returns false
	 }
	
	 
	 /*
	  * Returns true if this list contains the given element.
	  */  
	 public boolean contains(E element)
	 {
		 if(indexOf(element) == -1) // if index of the element is -1, return false because element doesn't exist
		 {
			 return false;
		 }
		 else // else, return true
		 {
			 return true;
		 }
	 }
	 
	 
	 /*
	  *	Returns the element of this list at the given index.
	  * Throws IndexOutOfBoundsException if index is out of range.
	  */
	 public E get(int index) 
	 {
		 if(index < -1 || index > mySize) // if index is NOT in range
		 {
			 throw new IndexOutOfBoundsException(); // throw IndexOutOfBoundsExceptions
		 }
		 else 
		 {
			 return getNodeAt(index).getElement(); // else, get the node at the index and then get it's element
		 }
	 }
	 	
	 
	 /*
	  * Returns the first index where the given element occurs in this list, 
	  * or -1 if the element is not in this list.
	  */
	 public int indexOf(E element)
	 {
		 Node tempNode = myFront.getNext(); // accesses the front of a node and sets it equal to a variable
		 int i = 0; 
		 while (tempNode.getNext() != null) // checks if the next value is null or NOT
		 {
			 if(tempNode.getElement().equals(element)) // checks if get element equals the element
			 {
				 return i; // then return the index of the element
			 } 
			 
			 else
			 {
				 i++; // increment the i
				 tempNode = tempNode.getNext(); // set the value of tempNode to the next value
			 }
		 }
		 return -1; // returns -1 if the element is not in the list
	 }
	 
	 	  
	 /*
	  * Returns the last index where the given element occurs in this list, 
	  * or -1 if the element is not in this list.
	  */
	 public  int lastIndexOf(E element) // complete reverse of the indexOf method
	 {
		 Node tempNode = myBack.getPrevious(); 
		 int i = mySize - 1;
		 while (tempNode.getPrevious() != null){
			 if(tempNode.getElement().equals(element)) 
			 {
				 return i;
			 } 
			 else 
			 {
				 i--;
				 tempNode = tempNode.getPrevious();
			 }
		 }
		 return -1;
	 }
	 
	 
	 /*
	  * Helper method: returns the node at the given index.
	  * -1 returns dummy header, and size() returns the dummy tail.
	  * Consider the effiency of this method. How can you write it 
	  * minimize the number of comparisons?
	  */
	 protected Node<E> getNodeAt(int index)  throws IndexOutOfBoundsException
	 {
		if(index < -1 || index > mySize)
		{
			throw new IndexOutOfBoundsException();
		}

		if(mySize == 0)
		{
			return myBack;
		}
		//Return the dummy header
		if(index == -1)
		{
			return myFront;
		}
		//Return the dummy tail
		if(index == mySize) 
		{
			return myBack;
		}
		
		//If none of the above, search from the beginning if it is in the first half
		if(index <= mySize/2) 
		{
			int i = 1;
			Node<E> tempNode = myFront.getNext();
			while (tempNode.getNext() != null) 
			{
				if(i == index) 
				{
					return tempNode;
				} 
				else 
				{
					tempNode = tempNode.getNext();
					i++;
				}
			}
					
		} 
		else 
		{
			int i = mySize - 1;
			Node<E> tempNode = myBack.getPrevious();
			while(tempNode.getPrevious() != null) 
			{
				if (i == index) 
				{
					return tempNode;
				}
				else 
				{
					tempNode = tempNode.getPrevious();
					i--;
				}			
			}
		}

		 return null;
	 }
	 
	 
	 /* 
	  * Returns an array containing all of the elements in this list 
	  * in the correct order. 
	  */
	 public E[] toArray()
	 {
		 Object[] toArray = new Object[mySize]; // creates an array of type Object with the size of mySize
		 Node tempNode = myFront.getNext(); // creates a node and give the next value after myFront
		 int i = 0;
		 while(i < mySize) // while the index is in range
		 {
			 toArray[i] = tempNode.getElement(); // set the value of the tempNode into the index of the array
			 tempNode = tempNode.getNext();
			 i++; // increment the i
		 }
		 return (E[])toArray; // returns the array
	 }
	 
	 
	 /* 
	  * Returns a String representation of this list. 
	  */  
	 public String toString()
	 {
		 
		 String temp = "[";
		 
		 Node tempNode = myFront.getNext();
		 int i = 1;
		 while(tempNode.getNext()!=null) {
			 temp += tempNode.getElement();
			 tempNode = tempNode.getNext();
			 if(i < mySize) 
			 {
				 temp += ",";
			 }
			 i++;
			 
		 }
		 temp += "]";
		 return temp;
	 }
 
 

}
