package com.agenda.contatos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.contatos.api.model.Telefone;
import com.agenda.contatos.api.repository.query.TelefoneRepositoryQuery;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>, TelefoneRepositoryQuery {

}
