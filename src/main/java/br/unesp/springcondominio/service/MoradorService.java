package br.unesp.springcondominio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.repository.MoradorRepository;

@Component
public class MoradorService{

   @Autowired
   private MoradorRepository moradorRepository;

   public MoradorService(){

   }

   public Morador save(Morador entity){
      Morador persistedEntity = null;

      if (moradorRepository != null) {
         persistedEntity = moradorRepository.save(entity);
      }
      
      return persistedEntity;
   }

   public Morador update(Morador entity){
      Morador persistedEntity = null;

      if (moradorRepository != null) {
         persistedEntity = moradorRepository.save(entity);
      }
      
      return persistedEntity;
   }

   public void delete(Morador entity){
      if (moradorRepository != null){

         String nome = entity.getNome();
         moradorRepository.delete(entity);
         System.out.println("Morador " + nome + " excluído!");
      }
   }

   public List<Morador> findAll(){
      List<Morador> list = null;

      if (moradorRepository!= null){
         list = new ArrayList<>();
         list = moradorRepository.findAll();
      }

      return list;
   }
}
