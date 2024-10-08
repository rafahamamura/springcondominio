package br.unesp.springcondominio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.unesp.springcondominio.entity.StatusVisita;
import br.unesp.springcondominio.entity.TipoVisitante;
import br.unesp.springcondominio.entity.Visita;
import br.unesp.springcondominio.entity.Visitante;
import br.unesp.springcondominio.util.GeradorCpf;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class VisitaServiceTest {
   
   //private static String cpf = GeradorCpf.gerarCPF();
   @Autowired
   private VisitaService visitaService;

   @SuppressWarnings("deprecation")
   @Test
   @Order(1)
   @DisplayName("VisitaService.add(Visita)")
   void visitaservicesave2Visitante_shouldreturnentity(){
      // First create a Visita
      // Create entity
      Visita visita = new Visita();
      visita.setEntrada(new Date());
      visita.setSaida(new Date());
      visita.setStatus(StatusVisita.AGUARDANDO);

      // Create visitantes list
      List<Visitante> visitantes = new ArrayList<Visitante>();
      // Create single visitante
      Visitante visitante = new Visitante();
      visitante.setCpf(GeradorCpf.gerarCPF());
      visitante.setNome("Rafael Hamamura");
      visitante.setDataNascimento(new Date("2010/11/26"));
      visitante.setTipoVisitante(TipoVisitante.PARENTE);
      //visitante = visitanteService.save(visitante);
      // Add created visitante to ArrayList visitantes
      visitantes.add(visitante);

      Visitante visitante2 = new Visitante();
      visitante2.setCpf(GeradorCpf.gerarCPF());
      visitante2.setNome("Ricardo Honorato");
      visitante2.setDataNascimento(new Date("2015/05/26"));
      visitante2.setTipoVisitante(TipoVisitante.OUTRO);
      //visitante2 = visitanteService.save(visitante2);
      // Add created visitante to ArrayList visitantes
      visitantes.add(visitante2);

      // Save and return/set saved visitante
      visita.setVisitante(visitantes);

      System.out.println("----------------------------------");
      System.out.println(visita);
      System.out.println("----------------------------------");

      Visita v = visitaService.save(visita);
      
      assertEquals(visita, v);
   }
}
