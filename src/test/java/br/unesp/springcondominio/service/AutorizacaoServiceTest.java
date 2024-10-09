package br.unesp.springcondominio.service;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.unesp.springcondominio.entity.Autorizacao;
import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.entity.StatusAutorizacao;
import br.unesp.springcondominio.entity.StatusVisita;
import br.unesp.springcondominio.entity.TipoMorador;
import br.unesp.springcondominio.entity.TipoVisitante;
import br.unesp.springcondominio.entity.Visita;
import br.unesp.springcondominio.entity.Visitante;
import br.unesp.springcondominio.util.GeradorCpf;
import jakarta.transaction.Transactional;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@SuppressWarnings("deprecation")
public class AutorizacaoServiceTest {

   @Autowired
   AutorizacaoService autorizacaoService;

   @Autowired
   VisitaService visitaService;

   @Autowired
   MoradorService moradorService;

   @Test
   @Order(1)
   void criaAutorizacao_shouldreturnAutorizacaoEntity(){
      //Create visita
      Visita visita = new Visita();
      visita.setEntrada(new Date());
      visita.setSaida(new Date());
      visita.setStatus(StatusVisita.AGUARDANDO);

      //Create visitante
      Visitante v = new Visitante();
      v.setCpf(GeradorCpf.gerarCPF());
      v.setDataNascimento(new Date("1986/05/26"));
      v.setNome("Jorginho Beach Tennis");
      v.setTipoVisitante(TipoVisitante.PRESTADOR_SERVICO);

      List<Visitante> vList = new ArrayList<Visitante>();
      vList.add(v);

      visita.setVisitante(vList);
      visita = visitaService.save(visita);

      //Create morador
      Morador m = new Morador();
      m.setCpf(GeradorCpf.gerarCPF());
      m.setDataNascimento(new Date("2000/11/11"));
      m.setNome("João Pandolfi");
      m.setTipoMorador(TipoMorador.LOCATARIO);

      m = moradorService.save(m);

      Autorizacao autorizacao = new Autorizacao();
      autorizacao.setDataHoraAutorizacao(new Date());
      autorizacao.setMorador(m);
      autorizacao.setVisita(visita);
      autorizacao.setStatus(StatusAutorizacao.PENDENTE);
      Autorizacao a = autorizacaoService.criaAutorizacao(autorizacao);

      assertEquals(autorizacao, a);
   }

   @Test
   @Order(2)
   void alteraStatus_shouldReturnTrue(){
      long id = 102;
      
      Autorizacao autorizacao = autorizacaoService.findAutorizacaoById(id);
      //Optional<Visita> v = visitaService.findVisitaById(autorizacao.getVisita().getId());
      Visita v = autorizacao.getVisita();
      //if (v.isPresent()){
      //   visita = v.get();
      //   System.out.println("VISITA:   " + v);
      //   visita.setStatus(StatusVisita.AUTORIZADA);
      //}
      autorizacao.setVisita(v);
      autorizacao.setStatus(StatusAutorizacao.APROVADA);
      
      Autorizacao a = autorizacaoService.atuailizaAutorizacao(autorizacao);

      assertEquals(autorizacao, a);
   }
}
