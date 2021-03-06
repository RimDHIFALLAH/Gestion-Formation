package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;

public interface IFormateurService {
	Long addandmodifyFormateur(Formateur formateur);


	void supprimerFormateur(Long formateurId);
	
	Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours);
		
	List<Formateur> listFormateurs();

	Formateur getFormateurById(Long id);
}
