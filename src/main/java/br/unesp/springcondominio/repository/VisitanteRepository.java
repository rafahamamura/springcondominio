package br.unesp.springcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.springcondominio.entity.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante, Long>{

}
