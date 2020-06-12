package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Methode GET pour récupérer la ressource
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelGet() {
		System.out.println("Appel GET");

		List<Ville> listeVilles = villeBLOService.getInfoVille();

		return listeVilles;
	}
	
	// Methode GET avec param (filtre = rechercher une ville avec son codePostal par exemple) 
	// On retourne une liste de ville au cas où on aurait 2 villes avec un même nom par exemple si on cherche par nom
		@RequestMapping(value = "/ville/trouver", method = RequestMethod.GET)
		@ResponseBody
		public List<Ville> appelGetParam(@RequestParam(name = "codePostal" ) String monParam) {
			System.out.println("Appel GET avec param");

			List<Ville> listeVillesParam = villeBLOService.getInfoVilleParam(monParam);

			return listeVillesParam;
		}
	
	// Methode POST pour créer la ressource
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody Ville ville) {
		System.out.println("Appel POST");
		
		villeBLOService.creerVille(ville);

	}
	
	// Methode PUT pour modifier la ressource
	@RequestMapping(value = "/ville/modify", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestBody Ville ville) {
		System.out.println("Appel PUT");
		
		villeBLOService.modifierVille(ville);

	}

	
	
	// Methode DELETE pour supprimer la ressource.
	@RequestMapping(value = "/ville/delete{Code_commune_INSEE}", method = RequestMethod.DELETE)
	@ResponseBody
	public void appelDelete(@RequestParam(name = "codeCommuneINSEE" ) String codeCommuneINSEE) {
		System.out.println("Appel DELETE");
		
		villeBLOService.supprimerVille(codeCommuneINSEE);
	}
}
