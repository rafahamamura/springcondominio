package br.unesp.springcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.springcondominio.entity.Autorizacao;

@Repository
public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Integer>{

}
