import java.util.*;
abstract class Animal
{
    String Name;
    public void SetName(String Name)
    {
        this.Name=Name;
    }
    public String GetName()
    {
        return Name;
    }
    abstract void Eat();
}
class Dog extends Animal
{
    void Eat()
    {
        System.out.println("The dog "+Name+" is eating");
    }
}
public class Main
{
	public static void main(String[] args) {
	    Dog dog=new Dog();
	    dog.SetName("Gaurav");
	    dog.GetName();
	    dog.Eat();
	    
	}
}
