package com.agenda.contatos.api.repository.query;

import java.util.List;

import com.agenda.contatos.api.model.Telefone;

public interface TelefoneRepositoryQuery {

	public List<Telefone> buscarTelefonesPorPessoa(Long idPessoa);
	
	public void excluirPorPessoaId(Long id);
	
	void excluirNotIn(List<Long> telefoneIds, Long idPessoa);
}
