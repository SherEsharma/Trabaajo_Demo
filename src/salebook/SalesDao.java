package salebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class SalesDao {
public void insert_sales_Details(SalesDto sdto)
{
	try{  
		
        Class.forName("com.mysql.jdbc.Driver");  
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root","root");
		PreparedStatement p1=(PreparedStatement) con.prepareStatement("insert into imagedetail(photo_path) values(?)");
		  p1.setString(1, sdto.getFile_path());
		
		  p1.executeUpdate();
		}catch(Exception e){ 
			System.out.println(e);
			}  
}


}

