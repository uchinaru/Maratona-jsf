package com.algaworks.erp.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractPersistence {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
	EntityManager em = emf.createEntityManager();
	


}
