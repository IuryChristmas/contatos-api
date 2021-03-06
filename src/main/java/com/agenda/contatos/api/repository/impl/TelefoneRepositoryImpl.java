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

	@Override
	@SuppressWarnings("unchecked")
	public List<Telefone> buscarTelefonesPorPessoa(Long idPessoa) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new com.agenda.contatos.api.model.Telefone(tel.id, tel.ddd, tel.numero) FROM telefone tel ")
			.append("WHERE tel.pessoa.id = :idPessoa");
		
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idPessoa", idPessoa);
		
		return query.getResultList();
	}

	@Override
	public void excluirPorPessoaId(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM telefone WHERE id_pessoa = :id");
		
		Query query = manager.createQuery(sql.toString());
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

	@Override
	public void excluirNotIn(List<Long> telefoneIds, Long idPessoa) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM telefone WHERE id_pessoa = :id AND id NOT IN (:telefoneIds)");
		
		Query query = manager.createQuery(sql.toString());
		query.setParameter("id", idPessoa);
		query.setParameter("telefoneIds", telefoneIds);
		
		query.executeUpdate();
	}

}
