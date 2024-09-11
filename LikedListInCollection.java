import java.util.LinkedList;


public class LikedListInCollection
{
public static void main(String[] args)
{

LinkedList<Integer> list = new LinkedList<>();
list.addFirst(10);
list.addFirst(1);
list.addFirst(1);
list.addFirst(1);
list.addFirst(10);
System.out.println(list);
System.out.println(list.removeLast());


}

}
