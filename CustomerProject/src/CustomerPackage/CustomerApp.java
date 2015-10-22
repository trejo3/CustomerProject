package CustomerPackage;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Simple Java Program to connect Oracle database by using Oracle JDBC thin driver
 * Make sure you have Oracle JDBC thin driver in your classpath before running this program
 * @author
 */
public class CustomerApp {
	
	public static void main(String[] args) throws SQLException {
		String cont = "";
		Scanner keyboard = new Scanner(System.in);
		 String fullName=null;
		do 
		{
			System.out.println("Enter the full name: ");
			 fullName = keyboard.nextLine();
		
			System.out.println("");
			System.out.println("Matching records...");
			System.out.println("");
			CustomerDBInterface.retrieveCustomer(fullName);
		
			System.out.println("Press (1) to search for another customer or press (2) to Edit the customer's address.");
			cont = keyboard.nextLine();
		}while(cont.equals("1"));
		
		if(cont.equals("2"))
		{
			System.out.println("Enter customer's street:");
			String newStreet = keyboard.nextLine();
			
			System.out.println("Enter customer's city:");
			String newCity = keyboard.nextLine();
			
			System.out.println("Enter customer's state:");
			String newState = keyboard.nextLine();
			
			System.out.println("Enter customer's ZIP:");
			String newZIP = keyboard.nextLine();
			
			CustomerDBInterface.insertNewCustomerDB(newStreet, newCity, newState, newZIP, fullName);
		}
	}

}
