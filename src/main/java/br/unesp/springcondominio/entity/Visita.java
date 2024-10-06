package br.unesp.springcondominio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "visita")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"entrada", "saida"})
@ToString
public class Visita implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @ManyToOne
   @JoinColumn(name = "visitante_id")
   private List<Visitante> visitante;

   @Temporal(TemporalType.TIMESTAMP)
   private Date entrada;

   @Temporal(TemporalType.TIMESTAMP)
   private Date saida;

   @Enumerated(EnumType.STRING)
   private StatusVisita status;

   public Visita(){
      this.visitante = new ArrayList<>();

   }

   public void setVisitante(Visitante visitante){
      this.visitante.add(visitante);
   }
}
