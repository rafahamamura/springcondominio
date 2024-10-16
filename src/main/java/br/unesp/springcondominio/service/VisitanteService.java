package br.unesp.springcondominio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.springcondominio.entity.Visitante;
import br.unesp.springcondominio.repository.VisitanteRepository;

@Service
public class VisitanteService {

   @Autowired
   VisitanteRepository repository;

   public VisitanteService() {

   }

   public Visitante save(Visitante entity) {
      Visitante persistedEntity = null;

      if (repository != null) {
         persistedEntity = repository.save(entity);
      }

      return persistedEntity;
   }

   public Visitante update(Visitante entity) {
      if (repository != null) {
         return repository.save(entity);
      }

      return null;
   }

   public void deleteAll() {
      if (repository != null) {

         repository.deleteAll();
         System.out.println("Todos os Visitante excluídos");
      }
   }

   public long deleteVisitanteById(Long id) {
      long rows = 0;
      Optional<Visitante> visitante = repository.findById(id);
      if (visitante.isPresent()) {
         repository.delete(visitante.get());
         rows = repository.count();
      }
      return rows;
   }

   public List<Visitante> findAll() {
      List<Visitante> list = null;

      if (repository != null) {
         list = new ArrayList<>();
         list = repository.findAll();
      }

      return list;
   }

   public List<Visitante> findVisitanteByCpf(String cpf) {
      List<Visitante> visitante = null;
      if (repository != null) {
         visitante = new ArrayList<>();
         visitante = repository.findByCpf(cpf);
      }

      return visitante;
   }

   public List<Visitante> listarVisitantes() {
      return repository.findAll();
   }

   public Optional<Visitante> buscarPorId(Long id) {
      return repository.findById(id);
   }

   public Visitante salvar(Visitante morador) {
      return repository.save(morador);
   }

   public void deletar(Long id) {
      repository.deleteById(id);
   }

}
