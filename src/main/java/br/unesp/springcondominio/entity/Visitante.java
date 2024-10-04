package br.unesp.springcondominio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "PessoaVisitante")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper=true, includeFieldNames=true)
public class Visitante extends Pessoa{

   private static final long serialVersionUID = 1L;

   @Enumerated(EnumType.STRING)
   private TipoVisitante tipoVisitante;

   public Visitante(){

   }

}
