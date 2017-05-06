package finalproject.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {
	// Get SQL Connection
	public Connection getConnection(){
		Connection con = null;
		try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=DB;username=sa;password=Password123;");
        }
		catch(Exception ex)
		{
        	ex.printStackTrace();
        }
		return con;
	}
	// Execute query and get resultset
	public ResultSet executeStatement(String query){
		ResultSet rs = null;
		try
        {
            Connection con = getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        }
		catch(Exception ex)
		{
			ex.printStackTrace();	
		}
		return rs;
	}
}