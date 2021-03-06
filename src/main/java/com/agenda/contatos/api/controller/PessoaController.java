package com.agenda.contatos.api.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.contatos.api.business.PessoaBusiness;
import com.agenda.contatos.api.model.Pessoa;
import com.agenda.contatos.api.repository.filter.PessoaFilter;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaBusiness business;
	
	@GetMapping
	public Page<Pessoa> buscar(PessoaFilter filter, Pageable pageable) {
		return business.buscar(filter, pageable);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
		
		return ResponseEntity.ok(business.salvar(pessoa));
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {
		
		return ResponseEntity.ok(business.atualizar(pessoa));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Optional<Pessoa> pessoa = business.buscarPorId(id);
		
		if(!pessoa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Long id) {
		business.excluir(id);
	}
}
