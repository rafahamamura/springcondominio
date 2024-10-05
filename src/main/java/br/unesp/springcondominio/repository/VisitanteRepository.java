package br.unesp.springcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.springcondominio.entity.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long>{

}
