package com.agenda.contatos.api.business;


import java.util.List;
import java.util.stream.Collectors;

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
		Page<Pessoa> pessoas = repository.buscar(filter, pageable);
		for(Pessoa pessoa : pessoas.getContent()) {
			pessoa.setTelefones(telefoneBusiness.buscarTelefonesPorPessoa(pessoa.getId()));
		}
		
		return pessoas;
	}

	@Transactional(rollbackFor = Exception.class)
	public void excluir(Long id) {
		telefoneBusiness.excluirPorPessoaId(id);
		repository.deleteById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public Pessoa atualizar(Pessoa pessoa) {
		pessoa = repository.saveAndFlush(pessoa);
		
		telefoneBusiness.salvarTelefonesPorPessoa(pessoa);
		
		List<Long> telefoneIds = pessoa.getTelefones().stream().map(telefone -> telefone.getId()).collect(Collectors.toList());
		
		telefoneBusiness.excluirNotIn(telefoneIds, pessoa.getId());
		return pessoa;
	}

}
