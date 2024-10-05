package br.unesp.springcondominio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.entity.TipoMorador;
import br.unesp.springcondominio.repository.MoradorRepository;
import br.unesp.springcondominio.util.GeradorCpf;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MoradorServiceTest {

   @Autowired
   MoradorService ms = new MoradorService();

   @Autowired
   MoradorRepository mr;

   private Morador morador;
   private static Long idMorador;
   private static String generatedCpf = GeradorCpf.gerarCPF();
   
   @Test
   @Order(1)
   @DisplayName("MoradorService.add(Morador)")
   void testAdd() {
      System.out.println("ADD/INSERT morador");

      // Set morador default values
      morador = new Morador();

      morador.setNome("Rafael");

      // Garante que em qualquer teste, será utilizando um número de CPF aleatório
      morador.setCpf(this.generatedCpf);

      morador.setDataNascimento(new Date(1986, 05, 26));
      morador.setTipoMorador(TipoMorador.PROPRIETARIO);

      System.out.println(morador);

      Morador m = ms.save(morador);

      this.idMorador = m.getId();
      System.out.println("----------------------------------------");
      System.out.println(m);
      System.out.println("----------------------------------------");
      System.out.println(this.idMorador);
      System.out.println("----------------------------------------");

      assertEquals(morador, m);
   }

   @Test
   @Order(2)
   @DisplayName("MoradorService.update(Morador)")
   void testUpdate() {
      System.out.println("UPDATE morador");

      // Set morador default values
      List<Morador> moradoresList = ms.findMoradorByCpf(this.generatedCpf);

      // update only name
      for (Morador morador : moradoresList) {

         if (morador != null) {
            morador.setNome("Gabriel");
            System.out.println(morador);

            Morador m = ms.update(morador);
            this.idMorador = m.getId();

            System.out.println("----------------------------------------");
            System.out.println(m);
            System.out.println("----------------------------------------");
            //System.out.println(this.idMorador);
            //System.out.println("----------------------------------------");

            assertEquals(morador, m);
         }

      }

   }

   @Test
   @Order(3)
   @DisplayName("MoradorService.deleteMoradorById(Long)")
   void testDeleteMoradorById() {
      System.out.println("DELETE morador");
      System.out.println("ID Morador: " + this.idMorador);

      Optional<Morador> m = mr.findById(this.idMorador);
      if (m.isPresent()) {
         long rows = ms.deleteMoradorById(m.get().getId());
      }  
      
      // Busca novamente por morador
      m = mr.findById(this.idMorador);
      assertFalse(m.isPresent());
   }
}
