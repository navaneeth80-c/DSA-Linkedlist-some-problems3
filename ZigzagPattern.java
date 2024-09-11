import java.util.*;
// using array
/*public class ZigzagPattern
{
public static void main(String[] args)
{
int[] array = {1,2,3,4,5};
/*Integer[] objArray = new Integer[array.length];
int j=0;
for(int i : array)
{
	objArray[j++]=i;
}
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(objArray));

	//list = Arrays.asList(objArray);
	list.set(2,10);
	System.out.println(list.get(1));
	System.out.println(list);
	*/
	//zigZag(array);
/*
}

public static  void zigZag(int[] num)
{
	Integer[] obj = new Integer[num.length];
	for(int i=0;i<num.length;i++)
	{
		obj[i] = num[i];
	}
	
	ArrayList<Integer> list = new ArrayList<>(Arrays.asList(obj));
	int j=1,k=0;
	System.out.println(list);
	for(int i=1;i<num.length/2;i=i+2)
	{
	list.add((i),list.remove(num.length-1));
	System.out.println(list);
		j++;
	}
	System.out.println(list);
}
}
*/

// this is a kind of brute force aproach

public class ZigzagPattern
{




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

public void addFirst(int data)
{
	Node newNode = new Node(data);
	
	if(headNode == null)
	{
		headNode = tailNode = newNode;
		return;
	}
	
	 tailNode.nextNode = newNode;
	tailNode = tailNode.nextNode;
}

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

public Node getMiddleNode(Node head)
{
	if(head == null || head.nextNode == null)
	{
		return head;
	}
	Node fast = head.nextNode;
	Node slow = head;
		while(fast != null && fast.nextNode != null)
		{
			fast = (fast.nextNode).nextNode;
			slow = slow.nextNode;
		}
		tailNode = slow;
		return slow;
}

public Node zigzagPattern(Node head)
{
	if(head == null && head.nextNode == null)
	{
		return head;
	}
	
		Node midNode = getMiddleNode(head);
		Node nextNode = midNode.nextNode;
		midNode.nextNode = null;
		nextNode = reverse(nextNode);
		
		return merge(head,nextNode);
}



public Node reverse(Node head)
{
	while(head != null ||  head.nextNode != null)
	{
		return head; 
	}
	
	Node current=head,prev=null,next=null;
	 tempNode = current;
	while(current != null)
	{
		next = current.nextNode;
		current.nextNode = prev;
		prev = current;
		current = next;
		
	}
	return prev;
}



public Node merge(Node h1 , Node h2)
{
	tempNode = new Node(-1);
	Node temp1 = tempNode;
	Node temp2;
	while(h1 != null && h2 != null)
	{
		temp1.nextNode = h1;
		h1 = h1.nextNode;
		temp1 = temp1.nextNode;
		temp1.nextNode = h2;
		h2 = h2.nextNode;
		temp1 = temp1.nextNode;
	}
	
	
	while(h1 != null)
	{
		temp1.nextNode = h1;
		h1 = h1.nextNode;
		temp1 = temp1.nextNode;
	}
	
	while(h2 != null)
	{
		temp1.nextNode = h2;
		h2 = h2.nextNode;
		temp1 = temp1.nextNode;
	}
	return tempNode.nextNode;
}


public static void main(String[] args)
{
	ZigzagPattern list = new ZigzagPattern();
	list.addFirst(1);
	list.addFirst(2);
	list.addFirst(3);
	list.addFirst(4);
	//list.addFirst(5);
	list.display();
	list.headNode = list.zigzagPattern(list.headNode);
	list.display();	
}


}

