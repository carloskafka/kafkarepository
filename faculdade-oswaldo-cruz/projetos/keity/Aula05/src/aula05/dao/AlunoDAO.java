package aula05.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aula05.models.Aluno;

public class AlunoDAO {
	private static final String COMANDO_SQL_OBTER_ULTIMO_ID_ALUNO = "SELECT LAST_INSERT_ID()";
	private static final String COMANDO_SQL_SALVAR_ALUNO = "INSERT INTO aluno(nome, endereco) VALUES (?, ?)";

	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String STRING_CONEXAO_JDBC_MYSQL = "jdbc:mysql://localhost/foc?user=root&password=123456";

	static {
		try {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection(STRING_CONEXAO_JDBC_MYSQL);
	}

	public int inserir(Aluno aluno) {
		String sqlInsert = COMANDO_SQL_SALVAR_ALUNO;

		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, aluno.getNome());
			stm.setString(2, aluno.getEndereco());
			stm.execute();
			String sqlQuery = COMANDO_SQL_OBTER_ULTIMO_ID_ALUNO;
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					aluno.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluno.getId();
	}
}
