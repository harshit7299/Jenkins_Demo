package MySQLConnection;
import java.sql.*;
import java.util.*;

class Employee {
    int employeeID;
    String employeeName;
    int employeeSalary;
    String department;
}

public class MySQLSelectDML {
    // Update these variables with your database connection details
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/employeedb";
    static final String JDBC_USER = "root";
    static final String JDBC_PASS = "Hsc@7299";
    
    public static Connection getConnectionfun() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void addEmployee(Employee emp)
    {
    	Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Employee ID: ");
        emp.employeeID = sc.nextInt();

        System.out.print("Enter Employee Name: ");
        emp.employeeName = sc.next();

        System.out.print("Enter Employee Salary: ");
        emp.employeeSalary = sc.nextInt();

        System.out.print("Enter Employee Department: ");
        emp.department = sc.next();
        
        String sql="INSERT INTO employee(employeeID, employeeName, employeeSalary, EmployeeDepartment) VALUES (?, ?, ?, ?)";
        
        try {
        	PreparedStatement statement= getConnectionfun().prepareStatement(sql);
        	statement.setInt(1,emp.employeeID);
            statement.setString(2,emp.employeeName);
            statement.setInt(3,emp.employeeSalary);
            statement.setString(4,emp.department);	
            
            int rowInserted=statement.executeUpdate();
            if(rowInserted>0)
            {
            	System.out.println("Employee Added Succesfully");
            }
        }catch(SQLException e) {
        	e.printStackTrace();
        }
    }
    public static void deleteEmployee(Employee emp)
    {
    	Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter ID of Employee to delete: ");
        int id = sc.nextInt();
                
        String sql="DELETE FROM employee WHERE employeeID = ?";
                
        try{
             PreparedStatement statement= getConnectionfun().prepareStatement(sql);
            
                    
                    statement.setInt(1, id);
                    statement.executeUpdate();
                    
                    System.out.println("Employee with ID " + id + " Deleted in the database.");
        } 
        catch (SQLException e) 
        {
                    e.printStackTrace();
                }
    }
    public static void showEmployee()
    {
    	String sql="SELECT * FROM employee";
    	try {
    		Statement stmt=getConnectionfun().createStatement();
    		ResultSet result=stmt.executeQuery(sql);
    		
    		int count=0;
    		while(result.next())
    		{
    			int eid=result.getInt(1);
    			String ename=result.getString(2);
    			int esal=result.getInt(3);
    			String edept=result.getString(4);
    			
    			System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3)+" "+result.getString(4));
    		}
    	}
    	catch(SQLException e) {
        	e.printStackTrace();
        }
    }
    public static void updateEmployee(Employee emp)
    {
    	Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter ID of Employee to update: ");
        int id = sc.nextInt();

       
        System.out.print("Enter new Employee Name: ");
        emp.employeeName = sc.next();

        System.out.print("Enter new Employee Salary: ");
        emp.employeeSalary = sc.nextInt();

        System.out.print("Enter new Employee Department: ");
        emp.department = sc.next();
                
        String sql="UPDATE employee SET employeeName = ?, employeeSalary = ?, employeeDepartment = ? WHERE employeeID = ?";
                
        try{
             PreparedStatement statement= getConnectionfun().prepareStatement(sql);
            
                    statement.setString(1, emp.employeeName);
                    statement.setInt(2, emp.employeeSalary);
                    statement.setString(3, emp.department);
                    statement.setInt(4, id);

                    statement.executeUpdate();
                    System.out.println("Employee with ID " + id + " updated in the database.");
        } 
        catch (SQLException e) 
        {
                    e.printStackTrace();
                }

    }
    
    public static void main(String[] args) {
        
    	//checking database connectivity
    	Scanner sc = new Scanner(System.in);

        try {
            Connection connection = getConnectionfun();

            if(connection!=null)
            {
            	System.out.println("Connected");
            }

            // Close the database connection when done
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        Employee employee=new Employee();
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Delete an Employee");
            System.out.println("3. Show Employees");
            System.out.println("4. Update an Employee");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(employee);
                    break;
                case 2:
                    deleteEmployee(employee);
                    break;
                case 3:
                    showEmployee();
                    break;
                case 4:
                    updateEmployee(employee);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
    }
}
}