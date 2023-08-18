import java.util.*;
class Person{
    String name;
    Person(String name)
    {
        this.name=name;
    }
    public String toString()
    {
        return "Name : "+name;
    }
}
class Student extends Person{
    Student(String name)
    {
        super(name);
    }
    public void Study()
    {
        System.out.println("Student "+name+" is studying");
    }
}
class Teacher extends Person{
    Teacher(String name)
    {
        super(name);
    }
    public void Explain()
    {
        System.out.println("Teacher "+name+" is explaining");
    }
}
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Person person[]=new Person[3];
		
		for(int i=0;i<2;i++)
		{
		    System.out.print("Enter name of Student "+(i+1)+":");
		    person[i]=new Student(sc.next());
		}
		System.out.println("Enter name of Teacher: ");   
		person[2]=new Teacher(sc.next());
		for(int i=0;i<3;i++)
		{
		    if(person[i] instanceof Student)
		    ((Student)person[i]).Study();
		    else
		    ((Teacher)person[i]).Explain();
		}
	}
}
