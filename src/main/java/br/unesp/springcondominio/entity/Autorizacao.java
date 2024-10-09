package br.unesp.springcondominio.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
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
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @OneToOne
   @JoinColumn(name = "visita_id")
   private Visita visita;

   @OneToOne
   @JoinColumn(name = "morador_id")
   private Morador morador;

   @Temporal(TemporalType.TIMESTAMP)
   private Date dataHoraAutorizacao;

   @Enumerated(EnumType.STRING)
   private StatusAutorizacao status;

   public Autorizacao(){

   }

   public void setVisita(Visita v){
      this.visita = v;
      
   }
}
