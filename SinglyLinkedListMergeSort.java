import java.util.Random;

public class SinglyLinkedListMergeSort
{



/*

//node class.
public static class  Node
{
public int data;
public Node nextNode;
public Node(int data)
{
this.data = data;
}
}





//head tail temp declaration
public Node headNode = null;
public Node tailNode = null;
public Node tempNode = null;
public static int count = 0;






// adding the data to sort
public void addFirst(int data)
{
	Node newNode = new Node(data);
	count++;
	if(headNode == null)
	{
	headNode = tailNode = newNode;
	headNode.nextNode = null;
	return;
	}
	newNode.nextNode = headNode;
	headNode = newNode;
}






// display function verify the answer.
public void display()
{
	if(headNode == null)
	{
	return;
	}
	
	tempNode = headNode;
	while(tempNode != null)
	{
		System.out.print(tempNode.data+" ->");
		tempNode = tempNode.nextNode;
	}
	System.out.println("null");
}




// main
public static void main(String[] args)
{
	Random rand = new Random();
SinglyLinkedListMergeSort list = new SinglyLinkedListMergeSort();
	for(int i =0 ;i< 20 ;i++)
	{
		list.addFirst(rand.nextInt(101));
	}
	list.addFirst(10);
	list.display();
	list.headNode = list.sort(list.headNode);
	list.display();

}




// sorting function
public Node sort(Node head)
{
	if(head == null || head.nextNode== null)
	{
		return head;
	}
	
	
	
	Node midNode = getMiddleNode(head);
	
	Node rightMidNode = midNode.nextNode;
	
	midNode.nextNode = null;
	
	Node newLeftNode = sort(head);
	
	Node newRightNode = sort(rightMidNode);
	
	return merge(newLeftNode,newRightNode);
	
}



//this function is used to get the middle node to break the node each time recursively...
private Node getMiddleNode(Node head)
{
	Node fast = head.nextNode;
	Node slow = head;
	
	while(fast != null && fast.nextNode != null)
	{
		fast = (fast.nextNode).nextNode;
		slow = slow.nextNode;
	}
	return slow;
}

private Node merge(Node h1,Node h2)
{
	Node temp = new Node(-1);
	Node tnode = temp; 
	
	while(h1!= null && h2!=null)
	{
		if(h1.data < h2.data)
		{
			tnode.nextNode = h1;
			h1 = h1.nextNode;
			tnode = tnode.nextNode;
		}
		else
		{
		tnode.nextNode = h2;
		h2 = h2.nextNode;
		tnode =  tnode.nextNode;
		}
	}
	
	while(h1 != null)
	{
	tnode.nextNode = h1;
	h1 = h1.nextNode;
	tnode = tnode.nextNode;
	}
	while(h2 != null)
	{
	tnode.nextNode = h2;
	h2 = h2.nextNode;
	tnode = tnode.nextNode;
	}
	return temp.nextNode;
	
}


}

*/

public static class Node
{
	int data;
	Node nextNode;
	
	public Node(int data)
	{
		this.data = data;
	}
}

public Node headNode;
public Node tailNode;
public Node tempNode;

public void add(int data)
{
	Node newNode = new Node(data);
	if(headNode == null)
	{
		headNode = tailNode = newNode;
		newNode.nextNode = null;
		return;
	}
	newNode.nextNode = headNode;
	headNode = newNode;
}

public void display()
{
	tempNode = headNode;
	while(tempNode != null)
	{
		System.out.print(tempNode.data+"->");
		tempNode=tempNode.nextNode;
	}
	System.out.println("null");
}




public Node sort(Node head)
{
	if(head ==null || head.nextNode == null)
	{
		return head;
	}
		Node midNode = getNode(head);
		Node rNode = midNode.nextNode;
		midNode.nextNode = null;
		Node h1 = sort(head);
		Node h2 = sort(rNode);
		return merge(h1,h2);
}




public Node getNode(Node head)
{
	Node fast = head.nextNode;
	Node slow = head;
	while(fast!= null && fast.nextNode != null)
	{
		fast =(fast.nextNode).nextNode;
		slow = slow.nextNode;
	}
		return slow;
}




public Node merge(Node h1,Node h2)
{
	tempNode = new Node(-1);
	Node temp = tempNode;
	while(h1!= null && h2 != null)
	{
		if(h1.data < h2.data)
		{
			temp.nextNode = h1;
			h1 = h1.nextNode;
			temp = temp.nextNode;
		}else
		{
			temp.nextNode = h2;
			h2 = h2.nextNode;
			temp = temp.nextNode;
		}
	}
	
	while(h1 != null)
	{
		temp.nextNode = h1;
		h1 = h1.nextNode;
		temp = temp.nextNode;
	}
	
	while(h2 != null)
	{
	temp.nextNode =h2;
	h2 = h2.nextNode;
	temp = temp.nextNode;
	}
	return tempNode.nextNode;
}


public static void main(String[] args)
{
	SinglyLinkedListMergeSort list = new SinglyLinkedListMergeSort();
	list.add(1);
	list.add(-1);
	list.add(-10);
	list.add(15);
	list.add(12);
	list.add(10);
	list.add(19);
	list.add(41);
	list.add(-10);
	list.add(21);
	list.add(13);
	list.add(-100);
	list.add(-210);
	list.display();
	list.headNode=list.sort(list.headNode);
	list.display();
	
}
}





















