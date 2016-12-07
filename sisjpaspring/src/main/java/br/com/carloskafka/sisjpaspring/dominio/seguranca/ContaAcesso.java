package br.com.carloskafka.sisjpaspring.dominio.seguranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.carloskafka.sisjpaspring.utilitarios.Criptografia;

@Entity
@Table(name = "conta_acesso")
public class ContaAcesso implements Serializable {

	private static final long serialVersionUID = -1821592601306770562L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	@Column(name = "token")
	private String token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null & !senha.isEmpty()) {
			this.senha = Criptografia.converterParaMD5(senha);
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean possuiToken() {
		return token != null & !token.isEmpty();
	}

	public boolean possuiLogin() {
		return login != null && !login.isEmpty();
	}

	public boolean possuiId() {
		return id != null;
	}

	public boolean validarObrigatoriedadeDosDados() {
		boolean validado = true;

		if (login == null || login.isEmpty()) {
			validado = false;
			System.out.println("Informe um login");
		}
		if (senha == null || senha.isEmpty()) {
			validado = false;
			System.out.println("Informe uma senha");
		}
		return validado;
	}

	@Override
	public String toString() {
		return "ContaAcesso [id=" + id + ", login=" + login + ", senha="
				+ senha + ", token=" + token + "]";
	}

}
