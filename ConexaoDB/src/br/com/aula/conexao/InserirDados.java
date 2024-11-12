package br.com.aula.conexao; // Esta classe faz parte do Pacote br.com.aula.conexao

// Importação das Classes e Bibliotecas
import java.sql.Connection; //Importação de Classes e Bibliotecas necessárias
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Criação da classe InserirDados (Inserção de Dados no Banco)
public class InserirDados {
	public static void main(String[]args) {
		Connection conexao = ConexaoDB.conectar(); // Puxa o método Conectar para estabelecer a conexão com o Banco de Dados
		
		// Verifica se a conexão foi feita
		if(conexao != null) {
			// Define a instrução sql para inserir os dados na tabela alunos
			String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
			
			try { // Realização da inserção dos dados no banco de dados
				PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
				stmt.setString(1, "João Silva"); // Define o valor do primeiro (?)
				stmt.setInt(2, 20); // Define o valor do segundo (?)
				stmt.executeUpdate(); // Comando para inserir no Banco de Dados
			
				stmt.setString(1, "Maria Souza"); // Define o valor do primeiro (?)
				stmt.setInt(2, 22); // Define o valor do segundo (?)
				stmt.executeUpdate(); // Comando para inserir no Banco de Dados
				
				stmt.setString(1, "Pedro Santos"); // Define o valor do primeiro (?)
				stmt.setInt(2, 22); // Define o valor do segundo (?)
				stmt.executeUpdate(); // Comando para inserir no Banco de Dados
				
				System.out.println("Dados inseridos com sucesso!"); // Informa que os dados foram inseridos com sucesso
			} catch (SQLException e ) {
				System.err.println("Erro ao inserir dados: " + e.getMessage()); // Informa que houve um erro na inserção de dados
			} finally {   // Garante que o código será executado independentemente do sucesso ou falha da inserção
			  try {
				  if (conexao !=null) conexao.close(); 

			  } catch (SQLException e) {
				  System.err.println("Erro ao fechar conexão: " + e.getMessage()); // Exibe uma mensagem de erro caso ocorra um erro ao tentar fechar a conexão
			  }
			}
			
		}
	}
	
}
