package br.unesp.springcondominio.entity;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"dataNascimento"})
@ToString(callSuper=true, includeFieldNames=true)
public class Pessoa {
   private String nome;
   private Date dataNascimento;
   private String cpf;

   public Pessoa(){
      
   }
}
