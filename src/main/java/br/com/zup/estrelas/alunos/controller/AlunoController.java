package br.com.zup.estrelas.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	
	@Autowired
	AlunoService service;
	
	@PostMapping
	public Aluno insereAluno(@RequestBody Aluno aluno) {
		return this.service.insereAluno(aluno);
	}
	
	@GetMapping (path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAluno(@PathVariable Long matricula) {
		return this.service.buscaAluno(matricula);
	}
	
	@GetMapping (produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Aluno> listaAlunos() {
		return this.service.listaAlunos();
	}
	
	@GetMapping (path = "/cpf/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAlunoCpf(@PathVariable String cpf) {
		
		return this.service.buscaAlunoCpf(cpf);
	}
	
	@DeleteMapping (path = "matricula", produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean deletaAluno(@PathVariable Long matricula) {
		return this.service.deletaAluno(matricula);
	}
	
	@PutMapping (path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno alteraAluno(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		return this.service.alteraAluno(aluno);
	}
	
	
	
}
