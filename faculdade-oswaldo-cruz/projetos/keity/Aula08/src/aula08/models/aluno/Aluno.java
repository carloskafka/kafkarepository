package aula08.models.aluno;

import java.io.Serializable;

import aula08.models.Resultado;

public class Aluno implements Serializable{
	private static final long serialVersionUID = -5433362393639792726L;
	
	private int id;
	private String nome;
	private String endereco;

	public Aluno() {
	}

	public Aluno(int id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}

	public Aluno(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Resultado validarObrigatoriedadeDeDados() {
		Resultado resultado = new Resultado();

		resultado.setSucesso(true);

		if (nome == null || nome.isEmpty()) {
			resultado.adicionarErro("Informe um nome valido.");
		}
		if (endereco == null || endereco.isEmpty()) {
			resultado.adicionarErro("Informe um endereco valido.");
		}

		return resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", endereco=" + endereco + "]";
	}

}
