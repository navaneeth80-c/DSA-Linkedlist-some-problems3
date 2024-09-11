public class SinglyLinkedListRemovingTheLoop
{

//node
public static class Node
{
public int data;
public Node nextNode;

public Node(int data)
{
this.data = data;
}
}



//other node declaration

public Node headNode = null;
public Node tailNode = null;
public Node tempNode = null;
public static int count =0;





// addFirst function to add data to the node..

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


// function to display...

public void displayNode()
{
tempNode = headNode;
if(headNode == null){
return;
}
while(tempNode != null)
{
	System.out.print(tempNode.data);
	tempNode = tempNode.nextNode;
}
System.out.println();
}





// finding the middle node to make a loop
public Node fast = null;
public Node slow = null;



public Node middleNodeFinder()
{
fast = headNode;
slow = headNode;

while(fast != null && fast.nextNode != null)
{
fast = (fast.nextNode).nextNode;
slow = slow.nextNode;
}
return slow;
}


//public Node middleNode;



//loop checker...
public boolean isLoop()
{
fast = headNode;
slow = headNode;

while(fast !=null && fast.nextNode != null)
{
fast = (fast.nextNode).nextNode;
slow = slow.nextNode;
if(fast == slow)
{
return true;
}
}

return false;
} 



//loop remover...

public void loopRemove()
{
if (isLoop())
{
	// means loop is there
	slow = headNode;
	fast = headNode;
	while(fast!= null && fast.nextNode != null)
	{
	fast = (fast.nextNode).nextNode;
	slow = slow.nextNode;
	
		if(fast == slow)
		{
		fast= headNode;
			while(fast.nextNode != slow.nextNode)
			{
			fast = fast.nextNode;
			slow = slow.nextNode;
			}
			slow.nextNode = null;
			System.out.println(slow.data+" data link have been removed from the list"); 
			return;
	}
	}
	
}else
{
System.out.println("no loop");
}
}


 





public static void main(String[] args)
{
	SinglyLinkedListRemovingTheLoop list = new SinglyLinkedListRemovingTheLoop();
	list.addFirst(10);
	list.addFirst(1);
	list.addFirst(1);
	list.addFirst(1);
	list.addFirst(1);
	list.addFirst(1);
	list.addFirst(1);
	list.addFirst(1);
	list.addFirst(1);
	list.addFirst(1);
	list.displayNode();
	System.out.println(list.count);
	System.out.println(list.isLoop());
	list.tailNode.nextNode = list.middleNodeFinder();
	System.out.println(list.isLoop());
	list.loopRemove();
	System.out.println(list.isLoop());
}
}

	
	
