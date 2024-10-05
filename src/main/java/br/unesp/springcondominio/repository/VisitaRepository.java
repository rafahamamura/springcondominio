package br.unesp.springcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.springcondominio.entity.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer>{

}
