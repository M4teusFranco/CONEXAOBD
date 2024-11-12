package br.com.aula.conexao; // Esta classe faz parte do Pacote br.com.aula.conexao

//Importação de Classes e Bibliotecas 
import java.sql.Connection; //Importação de Classes e Bibliotecas necessárias
import java.sql.DriverManager;
import java.sql.SQLException;

// Criação da classe ConexaoDB (Conexão de Banco de Dados)
public class ConexaoDB {
	// Definindo parâmetros para a conexão
	private static final String URL = "jdbc:mysql://localhost:3306/aula_java_db";
	private static final String USUARIO = "root"; // Usuário Root (usuário para rodar internamente)
	private static final String SENHA = ""; // Senha do MySQL (a senha foi deixada em branco)
	
	//Método para se conectar ao Banco de Dados
	public static Connection conectar() {
		Connection conexao = null;
		try {
			// Carregando o driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// Tentando estabelecer conexão
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conexão realizada com sucesso!"); // Caso a conexão seja realizada
		} catch (ClassNotFoundException e) {
			System.err.println("Driver não conectado: " + e.getMessage()); // Caso dê erro no Driver, o sistema informará
		} catch (SQLException e) {
			System.err.println("Erro ao conectar: " + e.getMessage()); // Caso não seja possível conectar, o sistema informará
		}
		return conexao; // Retorna a mensagem informando o sucesso ou fracasso da conexão
	}
	
	// Método que executa a aplicação
	public static void main(String[] args) {
        conectar(); // Puxa o método de conexão com o Banco de Dados
	}
}
