import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Vector<String> list=new Vector();
        list.add("Mango");
        list.add("Banana");
        list.add("Apple");
        Iterator it=list.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println();
        list.set(1,"Guava");
        
        for(String x:list)
        {
            System.out.println(x);
        }
        System.out.println();
        System.out.println(list.get(2));
        list.remove(0);
        System.out.println();
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        
    }
}
