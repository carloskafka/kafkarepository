package aula09.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aula09.models.Resultado;
import aula09.models.aluno.Aluno;
import aula09.models.solicitacao.ParametroSolicitacao;

public class AlunoDAO implements IAluno {
	private static final String COMANDO_SQL_OBTER_ULTIMO_ID_ALUNO = "SELECT LAST_INSERT_ID() as id";
	private static final String COMANDO_SQL_OBTER_ALUNO_POR_ID = "SELECT id, nome, endereco FROM aluno WHERE id = ?";
	private static final String COMANDO_SQL_OBTER_ALUNO_POR_ENDERECO = "SELECT id, nome, endereco FROM aluno WHERE endereco LIKE ?";
	private static final String COMANDO_SQL_OBTER_ALUNO_POR_NOME = "SELECT id, nome, endereco FROM aluno WHERE nome LIKE ?";
	private static final String COMANDO_SQL_OBTER_TODOS_ALUNOS = "SELECT id, nome, endereco FROM aluno ";

	private static final String COMANDO_SQL_SALVAR_ALUNO = "INSERT INTO aluno(nome, endereco) VALUES (?, ?)";
	private static final String COMANDO_SQL_ALTERAR_ALUNO = "UPDATE aluno SET nome=?, endereco= ? WHERE id = ?";
	private static final String COMANDO_SQL_EXCLUSAO_ALUNO_POR_ID = "DELETE FROM aluno WHERE id = ?";

	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String STRING_CONEXAO_JDBC_MYSQL = "jdbc:mysql://localhost/foc?user=root&password=123456";

	private static PreparedStatement stm;
	private static Connection conn;

	static {
		try {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection obtemConexao() throws SQLException {
		conn = DriverManager.getConnection(STRING_CONEXAO_JDBC_MYSQL);
		return conn;
	}

	private boolean inserir(Aluno aluno) {
		boolean inserido = false;
		try {
			stm = obtemConexao().prepareStatement(COMANDO_SQL_SALVAR_ALUNO);
			stm.setString(1, aluno.getNome());
			stm.setString(2, aluno.getEndereco());
			inserido = stm.executeUpdate() != 0;
			if (inserido) {
				PreparedStatement stm2 = conn.prepareStatement(COMANDO_SQL_OBTER_ULTIMO_ID_ALUNO);
				ResultSet rs = stm2.executeQuery();
				if (rs.next()) {
					aluno.setId(Integer.parseInt(rs.getString(ParametroSolicitacao.ID.getDescricao())));
				}
			}
		} catch (SQLException e) {
			System.out.println("Falha durante a inclusão do " + aluno + ".\nDetalhes: " + e.getMessage());
		} finally {
			finalizar();
		}

		return inserido;
	}

	public Resultado editar(Aluno aluno) {
		Resultado resultado = new Resultado();
		String acao = "";
		boolean editado = false;

		if (aluno.getId() == 0) {
			editado = inserir(aluno);
			acao = "Inclusao";
		} else {
			editado = alterar(aluno);
			acao = "Alteracao";
		}
		if (editado) {
			resultado.adicionarMensagem(acao + " do " + aluno + " realizada com sucesso.");
			resultado.efetuadoComSucesso(aluno);
		} else {
			resultado.adicionarErro("Falha durante a " + acao + " do " + aluno + ".");
		}

		return resultado;
	}

	private boolean alterar(Aluno aluno) {
		boolean inserido = false;

		try {
			stm = obtemConexao().prepareStatement(COMANDO_SQL_ALTERAR_ALUNO);
			stm.setString(1, aluno.getNome());
			stm.setString(2, aluno.getEndereco());
			stm.setString(3, String.valueOf(aluno.getId()));
			inserido = stm.executeUpdate() != 0;
		} catch (SQLException e) {
			System.out.println("Falha durante a alteracao do " + aluno);
			System.out.println(e.getMessage());
		} finally {
			finalizar();
		}

		return inserido;
	}

	public ArrayList<Aluno> listarAlunos() {
		ArrayList<Aluno> alunos = new ArrayList<>();

		try {
			stm = obtemConexao().prepareStatement(COMANDO_SQL_OBTER_TODOS_ALUNOS);

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int idObtido = rs.getInt(ParametroSolicitacao.ID.getDescricao());
				String nomeObtido = rs.getString(ParametroSolicitacao.NOME.getDescricao());
				String enderecoObtido = rs.getString(ParametroSolicitacao.ENDERECO.getDescricao());

				alunos.add(new Aluno(idObtido, nomeObtido, enderecoObtido));
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			finalizar();
		}

		return alunos;
	}

	private void finalizar() {
		try {
			if (stm != null && conn != null) {
				stm.close();
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Aluno> listarAlunosPorNome(String nome) {
		ArrayList<Aluno> alunos = new ArrayList<>();

		try {
			stm = obtemConexao().prepareStatement(COMANDO_SQL_OBTER_ALUNO_POR_NOME);
			stm.setString(1, "%" + nome + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int idObtido = rs.getInt(ParametroSolicitacao.ID.getDescricao());
				String nomeObtido = rs.getString(ParametroSolicitacao.NOME.getDescricao());
				String enderecoObtido = rs.getString(ParametroSolicitacao.ENDERECO.getDescricao());

				alunos.add(new Aluno(idObtido, nomeObtido, enderecoObtido));
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			finalizar();
		}

		return alunos;
	}

	public ArrayList<Aluno> listarAlunosPorEndereco(String endereco) {
		ArrayList<Aluno> alunos = new ArrayList<>();

		try {
			stm = obtemConexao().prepareStatement(COMANDO_SQL_OBTER_ALUNO_POR_ENDERECO);
			stm.setString(1, "%" + endereco + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int idObtido = rs.getInt(ParametroSolicitacao.ID.getDescricao());
				String nomeObtido = rs.getString(ParametroSolicitacao.NOME.getDescricao());
				String enderecoObtido = rs.getString(ParametroSolicitacao.ENDERECO.getDescricao());

				alunos.add(new Aluno(idObtido, nomeObtido, enderecoObtido));
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			finalizar();
		}

		return alunos;
	}

	public ArrayList<Aluno> listarAlunosPorId(int id) {
		ArrayList<Aluno> alunos = new ArrayList<>();

		try {
			stm = obtemConexao().prepareStatement(COMANDO_SQL_OBTER_ALUNO_POR_ID);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int idObtido = rs.getInt(ParametroSolicitacao.ID.getDescricao());
				String nomeObtido = rs.getString(ParametroSolicitacao.NOME.getDescricao());
				String enderecoObtido = rs.getString(ParametroSolicitacao.ENDERECO.getDescricao());

				alunos.add(new Aluno(idObtido, nomeObtido, enderecoObtido));
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			finalizar();
		}

		return alunos;
	}

	@Override
	public List<Aluno> listarAlunosPor(String chave, String valor) {
		List<Aluno> alunos = new ArrayList<>();

		if ((chave != null && !chave.isEmpty()) && (valor != null && !valor.isEmpty())) {
			if (chave.equals(ParametroSolicitacao.ID.getDescricao())) {
				alunos = listarAlunosPorId(Integer.parseInt(valor));
			} else if (chave.equals(ParametroSolicitacao.NOME.getDescricao())) {
				alunos = listarAlunosPorNome(valor);
			} else if (chave.equals(ParametroSolicitacao.ENDERECO.getDescricao())) {
				alunos = listarAlunosPorEndereco(valor);
			}
		}

		return alunos;
	}

	@Override
	public boolean excluirPorId(int id) {
		boolean retorno = false;

		try {
			stm = obtemConexao().prepareStatement(COMANDO_SQL_EXCLUSAO_ALUNO_POR_ID);
			stm.setInt(1, id);
			retorno = stm.executeUpdate() != 0;
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			finalizar();
		}

		return retorno;
	}

}
