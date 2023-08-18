import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Stack<String> st=new Stack<>();
		st.push("Apple");
		st.push("Mango");
		st.push("Banana");
		for(String x:st)
		{
		    System.out.println(x);
		}
		st.pop();
		for(String x:st)
		{
		    System.out.println(x);
		}
	}
}
