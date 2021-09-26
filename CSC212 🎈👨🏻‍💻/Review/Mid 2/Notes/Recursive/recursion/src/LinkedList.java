public class LinkedList
{
	private Node head;
	private String name;

	public LinkedList(String name)
	{
		head = null;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public void addLast(int d)
	{
		addLast(head,d);
	}

	private void addLast(Node save, int d)
	{
		if (save == null)
			head = new Node(d);
		else if (save.getNext() == null)
			save.setNext(new Node(d));
		else
			addLast(save.getNext(),d);
	}
	
	public void printList()
	{	
		printList(head);
	}

	public void printList(Node save)
	{
		if (save != null)
		{
			System.out.print(save.getData() + "  ");
			printList(save.getNext());
		}
		else
			System.out.println();
	}

	public void printListReverse()
	{
		printListReverse(head);
	}

	private void printListReverse(Node save)
	{
		if (save != null)
		{
			printListReverse(save.getNext());
			System.out.println(save.getData());
		}
	}

	public void reverse(LinkedList l)
	{
		reverse(l,head);
	}
	
	public void reverse(LinkedList l,Node save)
	{
		if (save != null)
		{
			l.addFront(save.getData());
			reverse(l, save.getNext());
		}
	}
	
	public void addFront(int i)
	{
		Node temp = new Node(i);
		temp.setNext(head);
		head = temp;
	}

	public void copy(LinkedList l)
	{
		copy(l,head);
	}

	public void copy(LinkedList l,Node save)
	{
		if (save != null)
		{
			l.addLast(save.getData());
			copy(l, save.getNext());
		}
	}

	public boolean search(int target)
	{
		return search(head, target);
	}

	public boolean search(Node save,int target)
	{
		if (save == null)
			return false;
		else if (save.getData() == target)
			return true;
		else
			return search(save.getNext() , target);
	}
	
	public int count(int d)
	{
		return count(head,d);
	}

	public int count(Node save, int d)
	{
		if (save == null)
			return 0;
		else if (save.getData() == d)
			return 1 + count(save.getNext(),d);
		else
			return count(save.getNext(),d);
	}
}