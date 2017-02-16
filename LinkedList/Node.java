public class Node
{
    private Transporter value = null;
    private Node next = null;
    private Node previous = null;

    public Node(Transporter inValue)
    {
	value = inValue;
    }

    public void setValue(Transporter inVal)
    {
	value = inVal;
    }

    public void setNext(Node newNext)
    {
	next = newNext;
    }

    public void setPrevious(Node newPrevious)
    {
	previous = newPrevious;
    }

    public Transporter getValue()
    {
	return value;
    }

    public Node getNext()
    {
	return next;
    }

    public Node getPrevious()
    {
	return previous;
    }
}
