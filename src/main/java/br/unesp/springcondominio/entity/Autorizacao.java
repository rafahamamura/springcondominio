package br.unesp.springcondominio.entity;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"dataHoraAutorizacao"})
@ToString
public class Autorizacao {

   private int id;
   private Visita visita;
   private Morador morador;
   private LocalDateTime dataHoraAutorizacao;
   private StatusAutorizacao status;

   public Autorizacao(){

   }
}
