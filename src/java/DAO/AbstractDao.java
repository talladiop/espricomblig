
package DAO;

import java.sql.*;

//import org.apache.log4j.Logger;

public abstract class AbstractDao 
{

	protected StringBuffer sb = null;
	protected Connection conx = null;
	protected Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conx = DriverManager.getConnection("jdbc:mysql://localhost/espricomblig","root","");
                        //conx = DriverManager.getConnection("jdbc:mysql://192.168.1.1/smsdb","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conx;
	}
	

	protected Statement createStatement(){
		try {
			return getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void close(Connection conx){
		try {
			if(conx!=null){
				conx.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void close(Statement stm){
		try {
			if(stm!=null){
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void close(ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
