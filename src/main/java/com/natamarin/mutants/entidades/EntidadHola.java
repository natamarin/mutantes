package com.natamarin.mutants.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

public class EntidadHola {

	@Entity
	@Table(name = "PERSONA")
	public class Persona implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
		@GenericGenerator(name = "native", strategy = "native")
		@Column(name = "IDPER")
		private Long idPersona;

		@Column(name = "NUMIDEN")
		private String numeroIdentificacion;

		public Long getIdPersona() {
			return idPersona;
		}

		public void setIdPersona(Long idPersona) {
			this.idPersona = idPersona;
		}

		public String getNumeroIdentificacion() {
			return numeroIdentificacion;
		}

		public void setNumeroIdentificacion(String numeroIdentificacion) {
			this.numeroIdentificacion = numeroIdentificacion;
		}
		
		
	}
}
