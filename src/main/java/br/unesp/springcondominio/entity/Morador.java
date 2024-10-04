package br.unesp.springcondominio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper=true, includeFieldNames=true)
public class Morador extends Pessoa {

   private int idMorador;
   private TipoMorador tipoMorador;

   public Morador(){

   }

}
