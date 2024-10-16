package br.unesp.springcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.springcondominio.entity.Autorizacao;
import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.entity.Visita;

import java.util.List;

@Repository
public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{
   List<Autorizacao> findByVisita(Visita visita);
   List<Morador> findByMorador(Morador morador);

   Autorizacao getTopByOrderByIdDesc();
}