package com.blo;

import java.util.List;

import com.dto.Ville;

public interface VilleBLO {

	public List<Ville> getInfoVille();
	
	public List<Ville> getInfoVilleParam(String monParam);
	
	public void creerVille(Ville ville);
	
	public void modifierVille(Ville ville);
	
	public void supprimerVille(String codeCommuneINSEE);
	
}
