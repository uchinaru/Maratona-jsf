package com.algaworks.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Estamos informando ao JPA que esse classe e uma entidade do banco de dados.
@Table (name = "ramo_atividade") //Necessario caso o nome da tablea seja diferente do nome da classe/entidade.
public class RamoAtividade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id // informa ao HIBERNATER que essa variavel e a primariKey.
	@GeneratedValue( strategy = GenerationType.IDENTITY) //Cria o id ao inserir o dado e forca o banco a gerar de forma sequencial..
	private Long id;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RamoAtividade other = (RamoAtividade) obj;
		return Objects.equals(id, other.id);
	}
	
	public String toString() {
		
		return "O Id do ramo_ativade e: " + this.id;
	}
	
}
