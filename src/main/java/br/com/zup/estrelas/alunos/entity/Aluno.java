package br.com.zup.estrelas.alunos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Aluno {
	
	@Id
	private Long matricula;
	@Column(nullable=false)
	private String nome;
	@Column(name="data_nascimento", nullable=false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	@Column(unique=true)
	private String cpf;
	@Column(name="valor_mensalidade", nullable=false)
	private Float valorMensalidade;
	
	
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Float getValorMensalidade() {
		return valorMensalidade;
	}
	public void setValorMensalidade(Float valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
}
