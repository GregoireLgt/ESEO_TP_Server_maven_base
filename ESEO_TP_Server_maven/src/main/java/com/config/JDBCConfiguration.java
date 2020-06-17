package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	
	private static Logger logger = Logger.getLogger(JDBCConfiguration.class.getName());

	@Bean
	public static Connection getConnection() {

		String dbDriver = "com.mysql.jdbc.Driver";

		String bDD = "maven";
		String url = "jdbc:mysql://localhost:3306/" + bDD;
		String user = "admin";
		String password = "admin";
		Connection connection = null;
		// L'essaie de connexion à votre base de donées
		try {
			Class.forName(dbDriver);
			// création de la connexion
            if(connection == null) {
            	connection = DriverManager.getConnection(url, user, password);
            }
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur pendant la récupération du driver (" + dbDriver + ")" + e);
			e.printStackTrace();
			logger.log(java.util.logging.Level.WARNING, "Erreur lors de la récup du driver");
		} catch (SQLException e1) {
			System.out.println("Erreur pendant la creation de la connexion à la BDD." + e1);
			e1.printStackTrace();
			logger.log(java.util.logging.Level.WARNING, "Erreur lors de la connexion à la BDD");
		}
		return connection;
	}
}
