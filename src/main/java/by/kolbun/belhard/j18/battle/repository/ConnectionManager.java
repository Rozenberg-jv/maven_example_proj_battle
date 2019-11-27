package by.kolbun.belhard.j18.battle.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public static Connection connection;

	public ConnectionManager() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");

			Properties properties = new Properties();

			Class<? extends ConnectionManager> aClass = getClass();
			InputStream resourceAsStream = aClass.getResourceAsStream("/dbconfig.properties");
			properties.load(resourceAsStream);

			String path = properties.getProperty("db.path");
			String user = properties.getProperty("db.user");
			String pass = properties.getProperty("db.pass");

			connection = DriverManager.getConnection(path, user, pass);
		} catch (SQLException | IOException /*| ClassNotFoundException */e) {
			System.err.println("Error while configuring application");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		return connection;
	}

}
