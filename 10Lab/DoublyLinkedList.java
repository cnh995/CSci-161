public class DoublyLinkedList<E> {
 
    private Node head;
    private Node tail;
    private int size;
     
    public DoublyLinkedList() {
        size = 0;
    }

    private class Node {
        E element;
        Node next;
        Node prev;
 
        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() { return size; }
     

    public boolean isEmpty()
    {
	if(head != null)
	    return false;

	return true; 
    }

    public void addFirst(E element) {
        if(head == null)
	    {
		head = new Node(element, null, null);
      	    }
	else
	    {
		Node newNode = new Node(element, head, tail);
		Node oldHead = head;
		head = newNode;
		oldHead.prev = head;
	    }

	size++;

        System.out.println("added at 1st: "+element);
    }
     

    public void addLast(E element) {
	if(tail == null)
	    {
		tail = new Node(element, null, null);
	    }
	else
	    {
		Node newNode = new Node(element, head, tail);
		Node oldTail = tail;
		tail = newNode;
		oldTail.next = tail;
	    }
       
        System.out.println("added at last: "+element);
    }
     
/*
    public void iterateForward(){
         
        System.out.println("iterating forward..");
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }
     

    public void iterateBackward(){
         
        System.out.println("iterating backword..");
        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }
     
*/
    public void  removeFirst() {
	if(size == 0)
	    {
		System.out.println("Queue is empty!");
	    }
	else
	    {
		System.out.println("Removed from front: " + head.element);
		Node newHead = head.next;
		newHead.prev = tail;
		head = newHead;
	    }
        
    }
    
    
    public E getFirst() {
        if (size == 0) {
        	System.out.println("Queue is Empty!");
        	
        }
     
	System.out.println("The first element is: " + head.element);
        
        return head.element;  //return the element here 
    }
    
    
     

    public void removeLast() {
        if (size == 0) {
        	System.out.println("Queue is Empty!");
        	
        }
	else
	    {
		System.out.println("Removed from end: " + tail.element);
		Node newTail = tail.prev;
		newTail.next = head;
		tail = newTail;
	    }
        
       

    }
     
    
    public E getLast() {
        if (size == 0) {
        	System.out.println("Queue is Empty!");
        	
        }
        System.out.println("The Last Element is: " + tail.element);
       
        return tail.element; //return the last element
    }
    
    
    
    
    
    
    
  
}
