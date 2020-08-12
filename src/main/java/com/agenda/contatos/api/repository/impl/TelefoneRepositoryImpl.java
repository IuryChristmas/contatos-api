package com.agenda.contatos.api.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.agenda.contatos.api.model.Telefone;
import com.agenda.contatos.api.repository.query.TelefoneRepositoryQuery;

public class TelefoneRepositoryImpl implements TelefoneRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Telefone> buscarTelefonesPorPessoa(Long idPessoa) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tel FROM telefone tel ")
			.append("WHERE tel.pessoa.id = :idPessoa");
		
		Query query = manager.createQuery(sql.toString(), Telefone.class);
		query.setParameter("idPessoa", idPessoa);
		
		return query.getResultList();
	}

}