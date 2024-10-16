package br.unesp.springcondominio.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.springcondominio.entity.Autorizacao;
import br.unesp.springcondominio.entity.StatusAutorizacao;
import br.unesp.springcondominio.repository.AutorizacaoRepository;

@Service
public class AutorizacaoService {

   @Autowired
   AutorizacaoRepository repository;

   public Autorizacao criaAutorizacao(Autorizacao entity) {
      repository.flush();
      Autorizacao persistedEntity = null;
      if (repository != null) {
         persistedEntity = repository.save(entity);
      }

      return persistedEntity;
   }

   public Autorizacao atualizaAutorizacao(Autorizacao entity) {
      repository.flush();
      Autorizacao persistedEntity = null;
      if (repository != null) {
         persistedEntity = repository.save(entity);
      }

      return persistedEntity;
   }

   public boolean alterarStatus(Autorizacao autorizacao, StatusAutorizacao status) {
      repository.flush();
      autorizacao.setStatus(status);

      if (repository != null) {
         autorizacao = repository.save(autorizacao);
         return true;
      } else
         return false;
   }

   public Optional<Autorizacao> findAutorizacaoById(Long id) {
      repository.flush();
      Optional<Autorizacao> a = repository.findById(id);
      return a;
   }

   public Autorizacao getLastAutorizacao(){
      return repository.getTopByOrderByIdDesc();
   }

   public List<Autorizacao> listarAutorizacoes() {
      return repository.findAll();
  }

  public Autorizacao salvarAutorizacao(Autorizacao autorizacao) {
      return repository.save(autorizacao);
  }

  public void deletarAutorizacao(Long id) {
      repository.deleteById(id);
  }
}
