package com.algaworks.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.algaworks.erp.model.Empresa;

public class Empresas {

	private EntityManager entitymanager;

	public Empresas() {

	}

	public Empresas(EntityManager entityManager) {
		this.entitymanager = entityManager;
	}

	public Empresa porId(Long id) {
		return entitymanager.find(Empresa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> pesquisar(String nome){
		
		Query query = entitymanager.createQuery("from Empresa where nomeFantasia like :nomeFantasia");
		query.setParameter("nomeFantasia", nome + "%");
		
		return query.getResultList();
	}
	
	public Empresa guardar(Empresa empresa) {
		return entitymanager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		
		entitymanager.remove(empresa);
	}
}
