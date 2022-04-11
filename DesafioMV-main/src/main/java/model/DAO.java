package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// ** M�dulo de conex�o **/
	// Par�metros de conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbdesafiomv?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "153624";

	// M�todo de conex�o

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}

	/** CRUD CREATE **/
	public void inserirColaborador(JavaBeans colaborador) {
		String create = "insert into colaboradores (nome,cpf,comida) values (?,?,?)";
		try {
			// abrir conex�o com o banco
			Connection con = conectar();
			// Preparar a query para a execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conte�do das vari�veis JavaBeans
			pst.setString(1, colaborador.getNome());
			pst.setString(2, colaborador.getCpf());
			pst.setString(3, colaborador.getComida());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conex�o com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarColaborador() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> colaboradores = new ArrayList<>();
		String read = "select * from colaboradores order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o la�o abaixo s�ra executado enquanto houver colaboradores
			while (rs.next()) {
				// vari�veis de apoio que recebem os dados do banco
				String idcolab = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String comida = rs.getString(4);
				// populando o ArrayList
				colaboradores.add(new JavaBeans(idcolab, nome, cpf, comida));

			}
			con.close();
			return colaboradores;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
