package br.unesp.springcondominio.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.springcondominio.entity.Visita;
import br.unesp.springcondominio.repository.VisitaRepository;

@Service
public class VisitaService {

   @Autowired
   private VisitaRepository repository;

   public VisitaService() {
   }

   public Visita save(Visita entity) {
      Visita persistedEntity = null;

      if (repository != null) {
         persistedEntity = repository.save(entity);
      }

      return persistedEntity;
   }

   public Visita update(Visita entity) {
      if (repository != null) {
         return repository.save(entity);
      }

      return null;
   }

   public long deleteVisitaById(Long id) {
      long rows = 0;
      Optional<Visita> visita = repository.findById(id);
      if (visita.isPresent()) {
         repository.delete(visita.get());
         rows = repository.count();
      }
      return rows;
   }

   public Optional<Visita> findVisitaById(Long id) {
      if (repository.findById(id).isPresent()) {
         return repository.findById(id);
      } else
         return null;
   }

   public List<Visita> findAll() {
      return repository.findAll();
   }

   public List<Visita> listarVisitas() {
      return repository.findAll();
   }

   public Visita salvarVisita(Visita visita) {
      return repository.save(visita);
   }

   public void deletarVisita(long id) {
      repository.deleteById(id);
   }
}
