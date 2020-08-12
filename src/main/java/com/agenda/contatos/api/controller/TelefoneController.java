package com.agenda.contatos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.contatos.api.model.Telefone;
import com.agenda.contatos.api.repository.TelefoneRepository;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	private TelefoneRepository repository;
	
	@GetMapping("/{idPessoa}")
	public List<Telefone> buscarPorPessoa(@PathVariable Long idPessoa) {
		return repository.buscarTelefonesPorPessoa(idPessoa);
	}
	
	@PostMapping
	public ResponseEntity<Telefone> salvar(@RequestBody Telefone telefone) {
		
		return ResponseEntity.ok(repository.save(telefone));
	}
}
