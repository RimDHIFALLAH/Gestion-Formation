package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;

@Service
public class FormateurService implements IFormateurService{

   @Autowired
   FormateurRepository formateurRepository;
   @Override
   public Long addandmodifyFormateur(Formateur formateur) {
      formateurRepository.save(formateur);
      return formateur.getId();
   }



   @Override
   public void supprimerFormateur(Long formateurId) {
      formateurRepository.deleteById(formateurId);

   }
   @Override
   public Formateur getFormateurById(Long id) {
      Formateur form =  formateurRepository.getOne(id);
      return form;
   }


   @Override
   public Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours) {
      return null;

   }



   @Override
   public List<Formateur> listFormateurs() {

      return formateurRepository.findAll();
   }





}