public class SinglyLinkedListLoopIsThereAreNot
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
public static int count = 0; 
public void add(int data)
{
	Node newNode = new Node(data);
	count++;
	if(headNode == null)
	{
	headNode = tailNode = newNode;
	newNode.nextNode = null;
	return;
	}
	newNode.nextNode = headNode;
	headNode = newNode;

}
public Node fast =null;
public Node slow = null;
public Node middleNodeFinder()
{
fast = headNode;
slow = headNode;

	while(fast!=null && fast.nextNode!=null)
	{
	fast = (fast.nextNode).nextNode;
	slow = slow.nextNode;
	}
	return slow; 
}

public boolean loopChecker()
{
 public Node fast = headNode;
 public Node slow = headNode;

while(fast!= null && fast.nextNode != null)
{
fast = (fast.nextNode).nextNode;
slow = slow.nextNode;
if(fast == slow){
return true;
}
}
return false;

}

public static void main(String[] args)
{
SinglyLinkedListLoopIsThereAreNot list = new SinglyLinkedListLoopIsThereAreNot();
list.add(1);
list.add(1);
list.add(1);
list.add(1);
list.add(1);
list.add(1);
list.add(1);
list.add(1);
list.add(1);
System.out.println(list.count);
//list.tailNode.nextNode = list.middleNodeFinder();
System.out.println(list.loopChecker());
}
}
