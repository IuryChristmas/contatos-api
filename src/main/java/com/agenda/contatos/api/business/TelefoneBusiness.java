package com.agenda.contatos.api.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.contatos.api.model.Pessoa;
import com.agenda.contatos.api.model.Telefone;
import com.agenda.contatos.api.repository.TelefoneRepository;

@Service
public class TelefoneBusiness {

	@Autowired
	private TelefoneRepository repository;
	
	public void salvarTelefonesPorPessoa(Pessoa pessoa) {
		if(pessoa.getId() != null && !pessoa.getTelefones().isEmpty()) {
			pessoa.getTelefones().forEach(telefone -> telefone.setPessoa(new Pessoa(pessoa.getId())));
			pessoa.getTelefones().forEach(telefone -> repository.save(telefone));
		}
	}

	public void excluirPorPessoaId(Long id) {
		repository.excluirPorPessoaId(id);		
	}
	
	public List<Telefone> buscarTelefonesPorPessoa(Long idPessoa) {
		return repository.buscarTelefonesPorPessoa(idPessoa);
	}
	
	public Telefone salvar(Telefone telefone) {
		return repository.save(telefone);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	public void excluirNotIn(List<Long> telefoneIds, Long idPessoa) {
		repository.excluirNotIn(telefoneIds, idPessoa);		
	}
}
