package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public Ville findAllVilles() {
		Ville ville = null;
		
		Connection con = JDBCConfiguration.getConnection();
		
		ResultSet results = null;
		String requete = "SELECT * FROM ville_france";

		try {
		   Statement stmt = con.createStatement();
		   results = stmt.executeQuery(requete);
		   
		   while (results.next()) {
				System.out.println("rep : " + results.getString("Nom_commune"));
		   }

		} catch (SQLException e) {
		   //traitement de l'exception
		}
		return ville;
	}
}
