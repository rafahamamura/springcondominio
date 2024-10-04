package br.unesp.springcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.springcondominio.entity.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long>{

}
