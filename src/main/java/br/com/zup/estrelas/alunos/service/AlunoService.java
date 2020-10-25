package br.com.zup.estrelas.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@Service
public class AlunoService {

	
	@Autowired
	AlunoRepository repository;
	
	public Aluno insereAluno(Aluno aluno) {
		return this.repository.save(aluno);
	}

	public Aluno buscaAluno(Long matricula) {
		return this.repository.findById(matricula).get();
	}
	
	public List<Aluno> listaAlunos() {
		return (List<Aluno>) this.repository.findAll();
	}

	public Aluno buscaAlunoCpf(String cpf) {
		
		Optional<Aluno> aluno = this.repository.findByCpf(cpf);
		
		if (aluno.isPresent()) {
			return aluno.get();
		}
		return null;
	}
	
	public boolean deletaAluno(Long matricula) {
		
		boolean alunoExiste = this.repository.existsById(matricula);
		if (alunoExiste) {
			repository.deleteById(matricula);
			return true;
		}
		return false;
	}

	public Aluno alteraAluno(Aluno aluno) {
		
		boolean alunoExiste = repository.existsById(aluno.getMatricula());
		if (alunoExiste) {
		return repository.save(aluno);
		}
		return null;
	}
	
	
}
