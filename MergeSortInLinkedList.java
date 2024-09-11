import java.util.LinkedList;

public class MergeSortInLinkedList
{

public static void main(String[] args)
{
LinkedList<Integer> list = new LinkedList<>();
list.addFirst(11);
list.addFirst(12);
list.addFirst(13);
list.addFirst(14);
list.addFirst(15);
list.addFirst(16);
System.out.println(list);
}

public static void mid(LinkedList<Integer> list)
{
	System.out.println(list.headNode.data);

}
}
