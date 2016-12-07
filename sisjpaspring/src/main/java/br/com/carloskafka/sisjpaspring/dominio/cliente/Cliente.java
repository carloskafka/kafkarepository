package br.com.carloskafka.sisjpaspring.dominio.cliente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 2343004606153845227L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cnpj")
	private String cnpj;

	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "versao")
	private String versao;

	public Cliente() {
		versao = "";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public boolean possuiId() {
		return id != null;
	}

	public boolean validarObrigatoriedadeDosDados() {
		boolean validado = true;

		if (nome == null || nome.isEmpty()) {
			validado = false;
			System.out.println("Informe um nome");
		}
		if (cnpj == null || cnpj.isEmpty()) {
			validado = false;
			System.out.println("Informe um CNPJ");
		}
		if (razaoSocial == null || razaoSocial.isEmpty()) {
			validado = false;
			System.out.println("Informe uma Razao Social");
		}
		if (email  == null || email.isEmpty()) {
			validado = false;
			System.out.println("Informe um Email");
		}
		if (telefone  == null || telefone.isEmpty()) {
			validado = false;
			System.out.println("Informe um Telefone");
		}
		
		return validado;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", razaoSocial=" + razaoSocial + ", email=" + email
				+ ", telefone=" + telefone + "]";
	}

}
