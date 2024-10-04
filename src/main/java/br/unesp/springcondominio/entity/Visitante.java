package br.unesp.springcondominio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper=true, includeFieldNames=true)
public class Visitante extends Pessoa{

   private int idVisitante;
   private TipoVisitante tipoVisitante;

   public Visitante(){

   }

}
