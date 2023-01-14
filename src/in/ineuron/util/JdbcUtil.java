package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcLogicalCOnnection() throws SQLException {
		String dbLoc = "D:\\Java Projects\\SERVLETMVCAPP\\src\\in\\ineuron\\properties\\db.properties";
		HikariConfig config = new HikariConfig(dbLoc);
		HikariDataSource dataSource = new HikariDataSource(config);
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	@SuppressWarnings("unused")
	public static Connection physicalConnection() throws SQLException, IOException , FileNotFoundException {
		FileInputStream fis = new FileInputStream("D:\\Java Projects\\SERVLETMVCAPP\\src\\in\\ineuron\\properties\\db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		Connection connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
	
}
