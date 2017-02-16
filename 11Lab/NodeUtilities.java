import java.util.*;

public class NodeUtilities
{
    public Node root = null;

    public boolean add(int x)
    {
	root = add(x, root);
	return true;
    }

    private Node add(int x, Node bstree)
    {
	if(bstree == null)
	    {
		return new Node(x);
	    }

	if(x < bstree.value)
	    {
		bstree.left = add(x, bstree.left);
	    }
	else
	    {
		bstree.right = add(x, bstree.right);
	    }

	return bstree;
    }

    public NodeUtilities(int[] array)
    {
	ArrayList<Integer> list = new ArrayList<Integer>();

	for(int x : array)
	    {
		list.add(x);
	    }

	for(int x : list)
	    {
		add(x);
		System.out.println(x);
	    }
    }
}
