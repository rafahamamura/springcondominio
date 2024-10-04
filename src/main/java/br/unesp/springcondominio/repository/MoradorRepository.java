package br.unesp.springcondominio.repository;

import org.springframework.data.repository.CrudRepository;

import br.unesp.springcondominio.entity.Morador;

public interface MoradorRepository extends CrudRepository<Morador, Long>{

}
