public class SinglyLinkedList<T extends Comparable<T>>
{
    int size;
    private Node<T> head;

    // LinkedList constructor
    public SinglyLinkedList()
    {    
	head = new Node <T>(null);
	size = 0;
    }

    public void add(T data)
    {
	Node newNode = new Node(data);

	if(head == null)
	    {
		head = newNode;
	    }
	else
	    {
		Node curr = head;
		while(curr.getNext() != null)
		    {
			curr = curr.getNext();
		    }
		curr.setNext(newNode);
	    }
	size++;
    }

    public boolean remove(int index)	
    {
	Node curr = head;
	int j = 0;

	while(curr != null)
	    {
		if(index + 1 == j)
		    {
			curr.setNext(curr.getNext().getNext());
			size--;
			return true;
		    }

		j++;
		curr = curr.getNext();
	    }
	
	// removes the element at the specified position in this list.
	return false;
    }

    public String toString()
    {
	String output = "\n";
	Node curr = head;

	while(curr != null)
	    {
		if(curr.getData() == null)
		    {
			curr = curr.getNext();
		    }
		else
		    {
			output += curr.getData() + "\n";
			curr = curr.getNext();
		    }
	    }

	return output + "\n\n";
    }

    public boolean find(T data)
    {	
	Node curr = head;
	Node newNode = new Node(data);

	while(curr != null)
	    {
		if(curr.getData() == newNode.getData())
		    {
			return true;
		    }
		curr = curr.getNext();
	    }

	return false;
    }

    public int size()	
    {
	return size;
    }

    private class Node<E>
    {
	// reference to the next node in the chain,
	// or null if there isn't one.
	Node<E> next;
	// data carried by this node.
	// could be of any type you need.
	E data;
	
	// Node constructor
	public Node(E newData)
	{
	    data = newData;
	}
	
	public E getData()
	{
	    return data;
	}
	
	public Node<E> getNext()
	{
	    return next;
	}
	
	public void setNext(Node<E> newNext)
	{
	    next = newNext;
	}	
    }
}
