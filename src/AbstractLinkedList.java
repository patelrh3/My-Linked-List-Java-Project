/*
 Models a doubly-linked list with dummy header and tail.
 You should extend this class with your MyLinkedList to complete
 the implementation.
*/
public abstract class AbstractLinkedList<E> {
  protected final Node<E>  myFront, myBack;  // dummy header/tail
  protected int mySize;                      // # of elements in list

  /* Constructs a new empty list. */  
  public AbstractLinkedList() {
    myFront = new Node<E>(null);  
    myBack  = new Node<E>(null);
    myBack.setPrevious(myFront);
    myFront.setNext(myBack);
    mySize = 0;
  }

  /* Inserts the given element at the given index. */
  public void add(int index, E element) {
    checkIndex(index, size());

    Node<E> curr = getNodeAt(index);

    // create the new node to hold the new element
    Node<E> newNode = new Node<E>(element, curr.getPrevious(), curr);
	 
    (newNode.getNext()).setPrevious(newNode);
    (newNode.getPrevious()).setNext(newNode);
    
    mySize++;
  }

  /* Appends the given element to the end of this list.  Returns true. */  
  public void add(E element) {
    add(size(), element);
  }
  
  /*
    Removes the element of this list at the given index and returns it.
    Throws IndexOutOfBoundsException if index is out of range.
   */
  public void remove(int index) {
    checkIndex(index, size() - 1);

    // get the node to remove, and update the references
    Node<E> nodeToRemove = getNodeAt(index);
	 
    (nodeToRemove.getPrevious()).setNext(nodeToRemove.getNext());
    (nodeToRemove.getNext()).setPrevious(nodeToRemove.getPrevious());

    mySize--;
  }
  
  /*
    Sets the element of this list at the given index to have the given value.
    Throws IndexOutOfBoundsException if index is out of range.
   */
  public void set(int index, E value) {
    checkIndex(index, size() - 1);

    getNodeAt(index).element = value;
  }
  
  /* Returns the number of elements in this list. */
  public int size() {
    return mySize;
  }
  
  /* Returns true if this list contains no elements. */
  public boolean isEmpty() {
    return mySize == 0;
  }
  
  /* Removes all elements from this list. */  
  public void clear() {
    myFront.setNext(myBack);
    myBack.setPrevious(myFront);
    mySize = 0;
  }
  
  /*
   Helper method: Throws an IndexOutOfBoundsException
   if 0 <= index <= max is not true.
  */
  private void checkIndex(int index, int max) throws IndexOutOfBoundsException{
    if (index < 0 || index > max)
      throw new IndexOutOfBoundsException();
  }
  
  
  /*
  Removes the given element from this list, if it is present in the list.
  Returns true if the element was in the list and was removed.
  */
	 public abstract boolean remove(E element);
  
  
  /* Returns true if this list contains the given element. */  
    public abstract boolean contains(E element);
  
  /*
   Returns the element of this list at the given index.
   Throws IndexOutOfBoundsException if index is out of range.
   */
	  public abstract E get(int index);
  
  /*
   Returns the first index where the given element occurs in this list, 
   or -1 if the element is not in this list.
   */
	  public abstract int indexOf(E element);

  /*
   Returns the last index where the given element occurs in this list, 
   or -1 if the element is not in this list.
   */
	  public abstract int lastIndexOf(E element);
  
  /*
   Helper method: returns the node at the given index.
   -1 returns dummy header, and size() returns the dummy tail.
	  Consider the effiency of this method. How can you write it 
	  minimize the number of comparisons?
  */
	  protected abstract Node<E> getNodeAt(int index)  throws IndexOutOfBoundsException;
  
  /* 
	Returns an array containing all of the elements in this list 
	in the correct order. 
	*/
     public abstract E[] toArray();

  /* 
	  Returns a String representation of this list. 
	*/  
     public abstract String toString();
  
  
  /* Represents one doubly-linked node in the list. */
  protected class Node<E> {
    private E element;  /* The data element */
    private Node<E> next;  /* Reference to the next node in the list */
    private Node<E> prev;  /* Reference to the previous node in the list */
    
    /* Constructs a new node to store the given element, with no next node. */
    public Node(E element) {
      this(element, null, null);
    }
    
    /* Constructs a new node to store the given element and the given next node. */
    public Node(E element, Node<E> prev, Node<E> next) {
      this.element = element;
      this.prev = prev;
      this.next = next;
    }
	 /* Accessor methods. */
	 public E getElement(){
		 return element;
	 }
	 
	 public Node<E> getNext(){
		 return next;
	 }
	 
	 public Node<E> getPrevious(){
		 return prev;
	 }
	 
	 /* Mutator methods.*/
	 public void setElement(E el){
		 element = el;
	 }
	 
	 public void setNext(Node<E> newNext){
		 next = newNext;
	 }
	 
	 public void setPrevious(Node<E> newPrev){
		 prev = newPrev;
	 }
    
    /* Returns a string representation of this node.  */
    public String toString() {
      return "(" + element + ")";
    }
  }

}