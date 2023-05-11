import java.sql.*;
import p1.RegisterBean;
public class RegisterAction {
	public boolean Registerdetails(RegisterBean b){
		boolean status=false;
		String firstname=b.getFirstname();
		String lastname=b.getLastname();
		String username=b.getUsername();
		String password=b.getPassword();
		
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","login","login");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from userdata where username='"+username+"'and password='"+password+"'");
			     if(rs.next()){
			    	 status=false;
			     }else{
			    	 int i=st.executeUpdate("insert into userdata(firstname,lastname,username,password) values('"+firstname+"','"+lastname+"','"+username+"','"+password+"')");
			    	 		
			    	 if(i>0){
			    		 status=true;
			    	 }
			     }
    }catch(SQLException e){
   	 e.printStackTrace();
}
    return status;
	}
}


