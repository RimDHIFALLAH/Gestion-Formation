package com.esprit.examen;

import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.services.FormateurService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.esprit.examen.entities.Contrat.EXPERT;
import static com.esprit.examen.entities.Poste.Ingénieur;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IFormateurServiceTest {
    @Autowired
    FormateurService formateurService;

    @Test
    @Transactional
    public void testaddFormateur() {
        Formateur form = new Formateur(null,"rim","dhifallah",Ingénieur,EXPERT,"rim@esprit.tn","password123");
        formateurService.addandmodifyFormateur(form);
        Long id = form.getId();
        Assert.assertNotNull(id);
        Formateur savedForm = formateurService.getFormateurById(id);
        try {
            Assert.assertEquals("rim", savedForm.getNom());
            Assert.assertEquals("dhifallah", savedForm.getPrenom());
            Assert.assertEquals(Poste.Ingénieur, savedForm.getPoste());
            Assert.assertEquals(Contrat.EXPERT, savedForm.getContrat());
            Assert.assertEquals("rim@esprit.tn", savedForm.getEmail());
            Assert.assertEquals("password123", savedForm.getPassword());

        }finally {

            formateurService.supprimerFormateur(id);

        }
    }

    @Test
    @Transactional
    public void testmodifierFormateur() {
        Formateur form = new Formateur(null,"rim","dhifallah",Ingénieur,EXPERT,"rim@esprit.tn","password123");
        formateurService.addandmodifyFormateur(form);
        Long id = form.getId();
        Assert.assertNotNull(id);
        Formateur savedForm = formateurService.getFormateurById(id);
        savedForm.setId(id);
        savedForm.setNom("rim");
        savedForm.setPrenom("rim");
        savedForm.setEmail("rim1@esprit.tn");
        formateurService.addandmodifyFormateur(savedForm);
        Formateur updatedForm = formateurService.getFormateurById(id);
        try {
            Assert.assertEquals("rim", savedForm.getNom());
            Assert.assertEquals("rim", savedForm.getPrenom());
            Assert.assertEquals(Poste.Ingénieur, savedForm.getPoste());
            Assert.assertEquals(Contrat.EXPERT, savedForm.getContrat());
            Assert.assertEquals("rim1@esprit.tn", savedForm.getEmail());
            Assert.assertEquals("password123", savedForm.getPassword());

        } finally {
            formateurService.supprimerFormateur(id);
        }
    }

}