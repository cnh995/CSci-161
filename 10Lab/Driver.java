public class Driver
{
    public static void main(String a[])
    {
	DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

	dll.addFirst(10);
	dll.addFirst(34);
	dll.addLast(56);
	dll.addLast(364);
	//dll.iterateForward();
	dll.removeFirst();
	dll.removeLast();
	//dll.iterateBackward();
	dll.getFirst();
	dll.getLast();

	System.out.println("Is empty? " + dll.isEmpty()); 
    }
}
