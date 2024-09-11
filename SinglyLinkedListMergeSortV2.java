public class SinglyLinkedListMergeSortV2
{


// node class
public static class Node
{
public int data;
public Node nextNode;
public Node(int data)
{
this.data = data;
}

}

public Node headNode = null;
public Node tailNode = null;
public Node tempNode = null;
public static int count = 0;

public void add(int data)
{
	Node newNode = new Node(data);
	if(headNode == null)
	{
		headNode = tailNode = newNode;
		headNode.nextNode = null;
		return;	
	}
	newNode.nextNode = headNode;
	headNode=newNode;
}



public void display()
{

	if(headNode == null)
	{
	return;
	}
	tempNode = headNode ;
	while(tempNode != null)
	{
		System.out.print(tempNode.data+" ->");
		tempNode = tempNode.nextNode;
		
	}
	System.out.println("null");
}

public static void main(String[] ars)
{
SinglyLinkedListMergeSortV2 list = new SinglyLinkedListMergeSortV2();
list.add(41);
list.add(-100);
list.add(12);
list.add(1);
list.add(-10);
list.add(1);
list.add(-1);
list.add(10);
list.add(21);
list.add(10);
list.display();
list.headNode = list.sort(list.headNode);
list.display();

}

public Node sort(Node head)
{
	if(head == null || head.nextNode == null)
	{
		return head;					// if head is empty or single node return that node its IMP
	}
	
	Node midNode = getMiddleNode(head);
	Node rightNode = midNode.nextNode;
	midNode.nextNode = null;  // breaking the list into two parts
	Node newLeftNode = sort(head);
	Node newRightNode = sort(rightNode);
	return merge(newLeftNode,newRightNode); 
}

public Node getMiddleNode(Node head)
{
	Node fast = headNode.nextNode;// to get same node as middle in the eaven case.. 
	Node slow = head;
	while(fast != null && fast.nextNode != null)
	{
		fast = (fast.nextNode).nextNode;
		slow = slow.nextNode;
	}  
	return slow;                             
}


public Node merge(Node h1, Node h2)
{
	tempNode = new Node(-1);
	Node newNode = tempNode;
	while(h1 != null && h2 != null)
	{
			if(h1.data < h2.data)
			{	
				tempNode.nextNode = h1;
				h1 = h1.nextNode;
				tempNode = tempNode.nextNode;
			}else{
				tempNode.nextNode = h2;
				h2 = h2.nextNode;
				tempNode = tempNode.nextNode;
			}
	}
	
	while(h1 != null)
	{
		tempNode.nextNode = h1;
		tempNode = tempNode.nextNode;
		h1 = h1.nextNode;
		
	}
	while(h2 != null)
	{
		tempNode.nextNode = h2;
		tempNode = tempNode.nextNode;
		h2 = h2.nextNode;
		
	}
	return newNode.nextNode;
}

}
