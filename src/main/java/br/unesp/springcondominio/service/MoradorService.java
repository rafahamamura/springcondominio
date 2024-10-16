package br.unesp.springcondominio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.repository.MoradorRepository;

@Service
public class MoradorService {

   @Autowired
   private MoradorRepository repository;

   public MoradorService() {

   }

   public Morador save(Morador entity) {
      Morador persistedEntity = null;

      if (repository != null) {
         persistedEntity = repository.save(entity);
      }

      return persistedEntity;
   }

   public Morador update(Morador entity) {
      if (repository != null) {
         return repository.save(entity);
      }

      return null;
   }

   public void deleteAll() {
      if (repository != null) {

         repository.deleteAll();
         System.out.println("Todos os moradores excluídos");
      }
   }

   public long deleteMoradorById(Long id) {
      long rows = 0;
      Optional<Morador> morador = repository.findById(id);
      if (morador.isPresent()) {
         repository.delete(morador.get());
         rows = repository.count();
      }
      return rows;
   }

   public List<Morador> findAll() {
      List<Morador> list = null;

      if (repository != null) {
         list = new ArrayList<>();
         list = repository.findAll();
      }

      return list;
   }

   public List<Morador> findMoradorByCpf(String cpf) {
      List<Morador> morador = null;
      if (repository != null) {
         morador = new ArrayList<>();
         morador = repository.findByCpf(cpf);
      }

      return morador;
   }

   public List<Morador> listarMoradores() {
      return repository.findAll();
   }

   public Optional<Morador> buscarPorId(Long id) {
      return repository.findById(id);
   }

   public Morador salvar(Morador morador) {
      return repository.save(morador);
   }

   public void deletar(Long id) {
      repository.deleteById(id);
   }

}
