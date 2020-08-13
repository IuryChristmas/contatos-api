package com.agenda.contatos.api.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agenda.contatos.api.model.Pessoa;
import com.agenda.contatos.api.repository.PessoaRepository;
import com.agenda.contatos.api.repository.filter.PessoaFilter;

@Service
public class PessoaBusiness {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private TelefoneBusiness telefoneBusiness;
	
	@Transactional(rollbackFor = Exception.class)
	public Pessoa salvar(Pessoa pessoa) {
		pessoa = repository.saveAndFlush(pessoa);
		
		telefoneBusiness.salvarTelefonesPorPessoa(pessoa);
		
		return pessoa;
	}
	
	public Page<Pessoa> buscar(PessoaFilter filter, Pageable pageable) {
		return repository.buscar(filter, pageable);
	}

	@Transactional(rollbackFor = Exception.class)
	public void excluir(Long id) {
		telefoneBusiness.excluirPorPessoaId(id);
		repository.deleteById(id);
	}

}
