package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	public List<Ville> getInfoVille() {
		List<Ville> listeVilles;
		
		listeVilles = villeDAO.findAllVilles();
		return listeVilles;
	}

	@Override
	public List<Ville> getInfoVilleParam(String monParam) {
		List<Ville> listeVillesParam;
		
		listeVillesParam = villeDAO.findVilleParam(monParam);
		return listeVillesParam;
	}

	@Override
	public void creerVille(Ville ville) {
		
		villeDAO.creerVille(ville);

	}

	@Override
	public void modifierVille(Ville ville) {
		
		villeDAO.modifierVille(ville);
		
	}

	@Override
	public void supprimerVille(Ville ville) {
		
		villeDAO.supprimerVille(ville);
		
	}

}
