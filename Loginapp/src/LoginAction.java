
import java.sql.*;
public class LoginAction {
	
	public boolean userDetails(String username,String password){
		boolean status=false;
		Connection con=null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","login","login");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from userdata where username='"+username+"'and password='"+password+"'");
			     if(rs.next()){
			    	 status=true;
			     }
			     }catch(ClassNotFoundException e){
			     e.printStackTrace();
	             }catch(SQLException e){
	            	 e.printStackTrace();
		}
	             return status;
	}
}

