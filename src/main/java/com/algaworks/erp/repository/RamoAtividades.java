package com.algaworks.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.algaworks.erp.model.RamoAtividade;

public class RamoAtividades {

	private EntityManager entitymanager;

	public RamoAtividades() {

	}
	
	public RamoAtividades(EntityManager entityManager) {
		this.entitymanager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<RamoAtividade> pesquisar(String descricao){
		
		Query query = entitymanager.createQuery("from RamoAtividade where descricao like :descricao");
		query.setParameter("descricao", descricao + "%");
		
		return query.getResultList();
	}
}
