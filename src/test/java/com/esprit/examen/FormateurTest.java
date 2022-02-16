package com.esprit.examen;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.services.FormateurService;
import com.esprit.examen.services.IFormateurService;

import junit.framework.Assert;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormateurTest {
	@Autowired
	IFormateurService fs;
	private static final Logger l = LogManager.getLogger(FormateurService.class);
	@Test
	public void testAjoutFormateur() {
		Formateur formateur = new Formateur("AA","bb", Poste.Ingénieur, Contrat.EXPERT, "aa@ff.com","123"); 
	    
		Long  id = fs.addFormateur(formateur);
	    l.info("test  ajout  : ");
	    
	    Assert.assertFalse(id == 0);


	    Assert.assertTrue(formateur.getPoste().equals(Poste.Ingénieur));
	    Assert.assertTrue(formateur.getContrat().equals(Contrat.EXPERT));

	    

	    agent.supprimerFormateur(id);
	}
	

    Long  id = agent.addFormateur(f);
    l.info("test  ajout  : ");
    
    Assert.assertFalse(id == 0);


    Assert.assertTrue(f.getPoste().equals(Poste.Ingénieur));
    Assert.assertTrue(f.getContrat().equals(Contrat.EXPERT));

    

    agent.supprimerFormateur(id);
}
