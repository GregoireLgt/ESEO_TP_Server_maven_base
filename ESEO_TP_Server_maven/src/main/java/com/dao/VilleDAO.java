package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	
	public List<Ville> findAllVilles();
	
	public List<Ville> findVilleParam(String monParam);

	public void creerVille(Ville ville);
	
	public void modifierVille(Ville ville);
	
	public void supprimerVille(Ville ville);
}
