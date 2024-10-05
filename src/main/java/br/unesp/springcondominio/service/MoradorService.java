package br.unesp.springcondominio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.repository.MoradorRepository;

@Service
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
      if (moradorRepository != null) {
         return moradorRepository.save(entity);
      }
      
      return null;
   }

   public void deleteAll(){
      if (moradorRepository != null){

         moradorRepository.deleteAll();
         System.out.println("Todos os moradores excluídos");
      }
   }

    public long deleteMoradorById(Long id){
      long rows = 0;
      Optional<Morador> morador = moradorRepository.findById(id);
      if (morador.isPresent()){
         moradorRepository.delete(morador.get());
         rows = moradorRepository.count();
      }
      return rows;
   }

   public List<Morador> findAll(){
      List<Morador> list = null;

      if (moradorRepository!= null){
         list = new ArrayList<>();
         list = moradorRepository.findAll();
      }

      return list;
   }

   public List<Morador> findMoradorByCpf(String cpf){
      List<Morador> morador = null;
      if (moradorRepository!=null){
         morador = new ArrayList<>();
         morador = moradorRepository.findByCpf(cpf);
      }

      return morador;
   }

}
