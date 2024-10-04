package br.unesp.springcondominio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.entity.TipoMorador;
import br.unesp.springcondominio.util.GeradorCpf;

@SpringBootTest
public class MoradorServiceTest {

   private Morador morador;

   @Autowired
   MoradorService ms = new MoradorService();

   @Test
   @Order(1)
   @DisplayName("MoradorService.add(Morador)")
   void testAdd() {
      System.out.println("Add morador");

      morador = new Morador();
      morador.setNome("Rafael");

      // Garante que em qualquer teste, será utilizando um número de CPF aleatório
      morador.setCpf(GeradorCpf.gerarCPF());

      morador.setDataNascimento(new Date(1986, 05, 26));
      morador.setTipoMorador(TipoMorador.PROPRIETARIO);

      System.out.println(morador);

      Morador m = ms.save(morador);

      System.out.println("----------------------------------------");
      System.out.println(m);
      System.out.println("----------------------------------------");

      assertEquals(morador, m);
   }

   @Test
   @Order(2)
   @DisplayName("MoradorService.update(Morador)")
   void testUpdate(){
      System.out.println("Update morador");

      morador = new Morador();
      morador.setNome("Gabriel");
      
      // Garante que em qualquer teste, será utilizando um número de CPF aleatório
      morador.setCpf(GeradorCpf.gerarCPF());
      
      morador.setDataNascimento(new Date(1986, 05, 26));
      morador.setTipoMorador(TipoMorador.PROPRIETARIO);

      System.out.println(morador);

      Morador m = ms.update(morador);

      System.out.println("----------------------------------------");
      System.out.println(m);
      System.out.println("----------------------------------------");

      assertEquals(morador, m);
   }
}
