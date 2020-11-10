import java.util.HashMap;
import java.util.Map;
public class LinkedList
{
    private class node
    {
        int val;
        node tail;
    }
    private node head;
    public LinkedList()
    {
        head=null;
    }
    public void addHead(int x)
    {
        node n = new node();
        n.val = x;
        n.tail = head;
        head = n;
    }

    public void remove()
    {
        head = head.tail;
    }
    public int getHead()
    {
        return head.val;
    }
    public int length()
    {
        int l = 0;
        node n = head;
        while(n != null)
        {
            l++;
            n=n.tail;
        }
        return l;
    }
    public int cycle()
    {
        Map<node, Integer> map = new HashMap<>();
        int l = length();
        for(int i = 1;i <= l; i++)
        {
            if(map.containsKey(i))
                if(map.get(i) == 1)
                    return i; //return the # of the element which loops in the list
            map.put(head, 1);
        }
        return -1; //return -1 if there's no cycles
    }
    public static void main(String[] args)
    {
        LinkedList h = new LinkedList();
        h.addHead(1);
        h.addHead(5);
        h.addHead(5);
        System.out.println(h.length());
        while(h.length() !=0)
        {
            System.out.print(h.getHead() + " ");
            h.remove();
        }
        System.out.println("\n" + h.cycle()); //you'd have to specifically create a makeCycle function to have one
    }
}
