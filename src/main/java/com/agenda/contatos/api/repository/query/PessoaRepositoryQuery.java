package com.agenda.contatos.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.agenda.contatos.api.model.Pessoa;
import com.agenda.contatos.api.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery {

	public Page<Pessoa> buscar(PessoaFilter filter, Pageable pageable);
}
