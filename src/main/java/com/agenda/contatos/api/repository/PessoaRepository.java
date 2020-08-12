package com.agenda.contatos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.contatos.api.model.Pessoa;
import com.agenda.contatos.api.repository.query.PessoaRepositoryQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {

}
