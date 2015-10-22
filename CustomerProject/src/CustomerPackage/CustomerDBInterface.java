package CustomerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CustomerDBInterface {
	
    public static void retrieveCustomer(String fullName) throws SQLException {
    	
    	Connection conn = getConnection();

        String sql ="select customers.ID, customers.title, customers.fullname, customers.streetaddress, customers.city, customers.state, customers.zipcode, customers.email, customers.position, companies.company from customers, companies where customers.fullName = '"+fullName+"' AND customers.companyID = companies.CompanyID";
//System.out.println("sql :"+sql);
        
        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
    
        ResultSet result = preStatement.executeQuery();
      
        while(result.next()) {
            System.out.println("Customer Number: "+result.getString("ID")+"\n"+result.getString("Title")+result.getString("fullname")+"\n"+result.getString("streetaddress")+"\n"+result.getString("city")+" "+result.getString("state")+" "+result.getString("zipcode")+"\n"+result.getString("email")+"\n"+result.getString("position")+" at " + result.getString("company"));
            System.out.println("");
            System.out.println("--------------------------------");
            System.out.println("");
        }
        
        conn.close();

      
    }
    
    public static void insertNewCustomerDB(String newStreet, String newCity, String newState, String newZIP, String fullName) throws SQLException
    {
    	Connection conn = getConnection();

        String sql ="update customers set streetaddress = '" +newStreet+ "', city = '" +newCity + "', state = '" +newState + "', zipcode = '" + newZIP+ "' where fullname = '" + fullName + "' ";
        
        System.out.println("sql :"+sql);
        
//          creating PreparedStatement object to execute query
          PreparedStatement preStatement = conn.prepareStatement(sql);
   
          ResultSet result = preStatement.executeQuery();
         
   	 
    }
    
    public static Connection getConnection() throws SQLException
    {
    	//URL of Oracle database server
        String url = "jdbc:oracle:thin:system/password@localhost"; 
      
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "testuserDB");
        props.setProperty("password", "password");
      
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);
        
        return conn;
    }
    

}
