import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import CustomerPackage.CustomerDBInterface;


public class CustomerTest {

	
	@Test
	public void CheckRetrieval() throws SQLException
	
	{
		String fullName = "Camille Gill";
		CustomerDBInterface.retrieveCustomer(fullName);
	}

	
	@Test
	public void CheckUpdation() throws SQLException {
		
		
		String fullName = "Camille Gill";
		String newStreet = "ABC";
		String newCity = "city";
		String newState  = "NY";
		String newZIP = "3242423"; 
		
		CustomerDBInterface.insertNewCustomerDB(newStreet, newCity, newState, newZIP, fullName);
		
		
		
	}
	

}
