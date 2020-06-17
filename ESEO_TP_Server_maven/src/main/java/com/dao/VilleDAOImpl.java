package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public List<Ville> findAllVilles() {
		List<Ville> listeVilles = new ArrayList();
		
		Connection con = JDBCConfiguration.getConnection();
		
		ResultSet results = null;
		String requete = "SELECT * FROM ville_france";

		try(Statement stmt = con.createStatement()) {
		   results = stmt.executeQuery(requete); // NOSONAR
		   
		   while (results.next()) {
				Ville ville = new Ville();

				System.out.println(results.getString(1) + "   " + results.getString(2) + "   " + results.getString(3) + 
						"   " + results.getString(4) + "   " + results.getString(5) + "   " + results.getString(6) + "   " + results .getString(7));
				
				ville.setCodeCommune(results.getString(1));
				ville.setNomCommune(results.getString(2));
				ville.setCodePostal(results.getString(3));
				ville.setLibelleAcheminement(results.getString(4));
				ville.setLigne(results.getString(5));
				ville.setLatitude(results.getString(6));
				ville.setLongitude(results.getString(7));
				
				listeVilles.add(ville);
		   }
		   
		   results.close();
		   con.close();
		  


		} catch (SQLException e) {
		   //traitement de l'exception
			System.out.println(e);
		}
		System.out.println("############  GET - findAllVilles()      ##############");
		return listeVilles;
	}
	
	
	public List<Ville> findVilleParam(String monParam) {
		List<Ville> listeVillesParam = new ArrayList();

		Connection con = JDBCConfiguration.getConnection();

		ResultSet results = null;
		
		
		try(Statement stmt = con.createStatement()) {
			   results = stmt.executeQuery("SELECT * FROM ville_france WHERE Nom_commune = " + monParam); // NOSONAR
			   
			   while (results.next()) {
					Ville ville = new Ville();

					System.out.println(results.getString(1) + "   " + results.getString(2) + "   " + results.getString(3) + 
							"   " + results.getString(4) + "   " + results.getString(5) + "   " + results.getString(6) + "   " + results .getString(7));
				
					ville.setCodeCommune(results.getString(1));
					ville.setNomCommune(results.getString(2));
					ville.setCodePostal(results.getString(3));
					ville.setLibelleAcheminement(results.getString(4));
					ville.setLigne(results.getString(5));
					ville.setLatitude(results.getString(6));
					ville.setLongitude(results.getString(7));
					
					listeVillesParam.add(ville);
			   }
			   results.close();
			   con.close();
			   

			} catch (SQLException e) {
			   //traitement de l'exception
				System.out.println(e);
			}

		System.out.println("############  GET - findVilleParam(String monParam)      ##############");
		return listeVillesParam;
	}
	
	public void creerVille(Ville ville) {
		
		Connection con = JDBCConfiguration.getConnection();		
		try(Statement stmt = con.createStatement()) {
		
			   
			   String requeteCreation = "INSERT INTO ville_france(Code_commune_INSEE,Nom_commune,Libelle_acheminement,Ligne_5,Latitude,Code_postal,Longitude)"
						+ " values(" + ville.getCodeCommune() + ",'" + ville.getNomCommune() + "','"
						+ ville.getLibelleAcheminement() + "','" + ville.getLigne() + "'," + ville.getLatitude() + ","
						+ ville.getCodePostal() + "," + ville.getLongitude() + ")";		
		
			   	stmt.executeUpdate(requeteCreation);	
				con.close();

			   
		} catch (SQLException e) {
			//traitement exception
			System.out.println(e);
		}
		System.out.println("############  POST - creerVille(Ville ville)      ##############");
	}
	
	public void modifierVille(Ville ville) {
		Connection con = JDBCConfiguration.getConnection();		
		try(Statement stmt = con.createStatement()){
		
			   
			   String requeteModification = "UPDATE ville_france SET Nom_commune=' " + ville.getNomCommune() + "', Code_postal='"
						+ ville.getCodePostal() + "', Libelle_acheminement='" + ville.getLibelleAcheminement()
						+ "', Ligne_5 = '" + ville.getLigne() + "', Latitude='" + ville.getLatitude() + "', Longitude='"
						+ ville.getLongitude() + "'  WHERE Code_commune_INSEE=' " + ville.getCodeCommune() + "'";
			   	
			   stmt.executeUpdate(requeteModification);
			   con.close();

			   
		} catch (SQLException e) {
			//traitement exception
			System.out.println(e);
		}
	
		System.out.println("############  PUT - modifierVille(Ville ville)      ##############");	
	}
	
	public void supprimerVille(String codeCommuneINSEE) {
		
		Connection con = JDBCConfiguration.getConnection();		
		try(Statement stmt = con.createStatement()) {
		
			   String requeteSuppression = "DELETE FROM ville_france WHERE Code_commune_INSEE=' " + codeCommuneINSEE + "'";
			   	
			   stmt.executeUpdate(requeteSuppression);
			   con.close();

			   
		} catch (SQLException e) {
			//traitement exception
			System.out.println(e);
		}
		System.out.println("############  DELETE - supprimerVille(Ville ville)      ##############");	
	}
}
