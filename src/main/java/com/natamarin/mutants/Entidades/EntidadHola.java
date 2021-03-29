package com.natamarin.mutants.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class EntidadHola {

	@Entity
	@Table(name = "PERSONA")
	public class Persona implements Serializable {
		
		private static final long serialVersionUID = 1L;

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
