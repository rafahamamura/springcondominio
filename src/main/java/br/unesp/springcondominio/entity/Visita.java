package br.unesp.springcondominio.entity;

import java.util.Date;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"entrada", "saida"})
@ToString
public class Visita {

   private int id;
   private List<Visitante> visitante;
   private Date entrada;
   private Date saida;
   private StatusVisita status;

   public Visita(){

   }

   public void setVisitante(Visitante visitante){
      this.visitante.add(visitante);
   }
}
