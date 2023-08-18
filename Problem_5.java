import java.util.*;
interface IVehiculo{
    void drive();
    boolean Refuel(int gasoline);
}
class Car implements IVehiculo{
    int gasoline;
    Car(int gasoline){
        this.gasoline=gasoline;
    }
    public void drive()
    {
        if(gasoline>0)
        {
            System.out.println("The car is Driving");
        }
    }
    public boolean Refuel(int RefuelGasoline)
    {
        gasoline+=RefuelGasoline;
        return true;
    }
}
public class Main
{
	public static void main(String[] args) {
	    Car obj=new Car(0);
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Enter the amount of Gasoline required to refuel: ");
	    obj.Refuel(sc.nextInt());
	    obj.drive();
	}
}
