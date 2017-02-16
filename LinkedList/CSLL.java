public class CSLL
{
    private Node head = null;

    public CSLL()
    {
    }

    public void add(Transporter input)
    {
	//Put input into a box
	Node newNode = new Node(input);

	//Put the new node into the correct place
	//End of the list
	//Check for empty list
	if(head == null)
	    {
		head = newNode;
		head.setNext(head);
	    }
	else //The list isn't empty
	    {
		Node curr = head; //Start curr at head
		while(curr.getNext() != head) //While current node doesn't point to null, move on
		    {
			curr = curr.getNext(); //When the current node points to null, we know we are at the end (if single linked list)
		    }

		//Reached the end, set last item's next node to newNode
		curr.setNext(newNode);
		newNode.setNext(head);
	    }
    }

    public String toString()
    {
	String output = "My list:\n";
	Node curr = head;

	while(curr != head) //Step through list
	    {
		output += curr.getValue() + "\n\n";
		curr = curr.getNext();
	    }

	return output;
    }

    public Transporter remove(int i) //Remove element at index i
    {
	Node curr = head;
	int j = 0;

	while(curr != head)
	    {
		if(i + 1 == j)
		    {
			curr.setNext(curr.getNext().getNext());
			return curr.getValue();
		    }

		j++;
		curr = curr.getNext();
	    }

	return curr.getValue();
    }

    public Transporter removeFront() //Remove element from the front
    {
	if(head.getNext() != head)
	    {
		head = head.getNext();
	    }

	return head.getValue();
    }

    public Transporter removeBack() //Remove element from the back
    {
	Node curr = head;

	while(curr != null)
	    {
		if(curr.getNext().getNext() == head)
		    {
			curr.setNext(head);
			return curr.getValue();
		    }

		curr = curr.getNext();
	    }

	return curr.getValue();
    }

    public int search(Transporter t) //Find t within the linked list
    {
	Node curr = head;
	int i = 0;

	while(curr != null)
	    {
		if(curr.getValue().equals(t))
		    {
			return i;
		    }

		curr = curr.getNext();
		i++;
	    }

	return -1;
    }

    public boolean find(Transporter t) //Tells whether t is in the list or not
    {
	Node curr = head;
	Node newNode = new Node(t);

	while(curr != head)
	    {
		if(curr.getValue() == newNode.getValue())
		    {
			return true;
		    }

		curr = curr.getNext();
	    }

	return false;
    }

    public void add(Transporter t, int i)
    {
	Node curr = head;
	int j = 0;
	Node newNode = new Node(t);

	while(curr != head)
	    {
		if(i + 1 == j)
		    {
			newNode.setNext(curr.getNext());
			curr.setNext(newNode);
		    }

		if(curr.getNext() == head)
		    {
			curr.setNext(newNode);
			newNode.setNext(head);
		    }

		j++;
		curr = curr.getNext();
	    }
    }
}
