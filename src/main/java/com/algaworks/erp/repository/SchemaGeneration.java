package com.algaworks.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.erp.model.Empresa;

public class SchemaGeneration {
	
	public static void main(String[] args) {
		
		// CLASSE PARA TESTAR OS COMANDOS CRIADOS //
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		EntityManager em = emf.createEntityManager();
		
		List<Empresa> listEmpresas = em.createQuery("From Empresa", Empresa.class).getResultList();

			for(Empresa empresa: listEmpresas) {
				System.out.println("Nome empresa: " + empresa.getNomeFantasia());
			}
			
		emf.close();
		em.close();
	}

}
