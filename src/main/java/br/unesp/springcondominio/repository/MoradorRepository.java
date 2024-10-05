package br.unesp.springcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.springcondominio.entity.Morador;
import java.util.List;


@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long>{

   void deleteById(Long id);

   List<Morador> findByCpf(String cpf);
}
