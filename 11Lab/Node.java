public class Node
{
    int value;
    Node right;
    Node left;

    public Node(int inValue)
    {
	value = inValue;
	right = null;
	left = null;
    }

    public Node(int inValue, Node inLeft, Node inRight)
    {
	value = inValue;
	right = inRight;
	left = inLeft;
    }
}
