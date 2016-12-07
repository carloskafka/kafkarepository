package br.com.carloskafka.sisjpaspring.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class RepositorioDB<DOMINIO> {
	@PersistenceContext
	protected EntityManager em;
}
