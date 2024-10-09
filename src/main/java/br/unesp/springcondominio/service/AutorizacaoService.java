package br.unesp.springcondominio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.springcondominio.entity.Autorizacao;
import br.unesp.springcondominio.entity.StatusAutorizacao;
import br.unesp.springcondominio.repository.AutorizacaoRepository;

@Service
public class AutorizacaoService {

   @Autowired
   AutorizacaoRepository repository;

   public Autorizacao criaAutorizacao(Autorizacao autorizacao) {
      if (repository != null) {
         autorizacao = repository.save(autorizacao);
      } else {
         autorizacao = null;
      }

      return autorizacao;
   }

   public Autorizacao atuailizaAutorizacao(Autorizacao autorizacao) {
      if (repository != null) {
         autorizacao = repository.save(autorizacao);
      } else {
         autorizacao = null;
      }

      return autorizacao;
   }

   public boolean alterarStatus(Autorizacao autorizacao, StatusAutorizacao status) {

      autorizacao.setStatus(status);

      if (repository != null) {
         autorizacao = repository.save(autorizacao);
         return true;
      } else
         return false;
   }

   public Autorizacao findAutorizacaoById(Long id) {
      Optional<Autorizacao> a = repository.findById(id);
      if (a.isPresent()) {
         Autorizacao autorizacao = a.get();
         return autorizacao;
      } else {
         return null;
      }
   }
}
