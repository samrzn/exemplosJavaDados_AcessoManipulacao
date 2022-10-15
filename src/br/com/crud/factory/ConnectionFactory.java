package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

	// declaração "static final" define variável sem imutável.
	private static final String USERNAME = "root";
	private static final String PASSWORD = "m3lo0698Dram4*";

	// caminho, porta e nome da base de dados que será conectada.
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud";

	// endereço do driver Connector/J.
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static Connection createConnectionToMySQL() throws Exception {
		// indica a classe do driver para o JVM.
		Class.forName(DRIVER_NAME);

		// método de conexão com o banco de dados através do driver.
		Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conn;
	}

	public static void main(String[] args) throws Exception {
		
		// teste de validade da conexão.
		System.out.println("Iniciando teste ConnectionFactory.");
		Connection conx = createConnectionToMySQL();
		if (conx != null) {
			System.out.println("Conexão estabelecida!");
			
			// teste de funcionamento da conexão.
			Statement st = conx.createStatement();
			ResultSet resu = st.executeQuery("SELECT * FROM CONTATOS");
			System.out.println("Exibindo de 'contatos': nome -> idade.");
			while (resu.next()) {
				System.out.println(resu.getString("NOME") + " -> " + resu.getInt("IDADE"));
			}
			st.close();
			conx.close();
			System.out.println("Fim da conexão.");
		}
	}
}