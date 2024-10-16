package br.unesp.springcondominio.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "autorizacao")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"dataHoraAutorizacao"})
@ToString
public class Autorizacao implements Serializable{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "visita_id")
   private Visita visita;

   @ManyToOne
   @JoinColumn(name = "morador_id")
   private Morador morador;

   @Temporal(TemporalType.TIMESTAMP)
   private Date dataHoraAutorizacao;

   @Enumerated(EnumType.STRING)
   private StatusAutorizacao status;

   public Autorizacao(){

   }
}
