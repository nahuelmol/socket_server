package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class Conn {
	
	public Conn (){
		Connection conn;
		String port = "5432";
		String url;
		Properties props;
	}

	public static void handle(){
		
		this.url = "jdbc:postgresql://localhost:"+this.port+"/postgres";
		this.props = new Properties();

		this.props.setProperty("user","postgres");
		this.props.setProperty("ssl","true");

		try{
			this.conn = DriverManager.getConnection(url, this.props);
		}catch(SQLException e){
			System.out.println("ERR:errcode="+ e.getErrorCode() + "&SQLstate="+e.getSQLState());
		}
	}
}