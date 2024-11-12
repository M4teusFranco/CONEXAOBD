package br.com.aula.conexao; // Esta classe pertence ao pacote br.com.aula.conexao
import java.sql.Connection; //Importação de Classes e Bibliotecas necessárias
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Criação da classe LerDados (Consulta de registros no Dados no Banco)
public class LerDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoDB.conectar(); // Puxa o método Conectar para estabelecer a conexão com o Banco de Dados
		
		// Verifica se a conexão foi feita
		if (conexao != null) {
			// Define a instrução sql para ler todos os dados na tabela alunos
			String sql = "SELECT * FROM alunos"; 
			
			try { // Tentativa de ler os dados da tabela
				PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
				ResultSet rs = stmt.executeQuery(); // Faz a consulta e armazena os resultados no ResultSet
			
				System.out.println("Registro da tabela 'alunos':"); // Título da exibição dos dados
				while (rs.next()) { // Loop para percorrer os dados retornados pela consulta
					int id = rs.getInt("id"); // Puxa o ID dos alunos
					String nome = rs.getString("nome"); // Puxa o Nome dos alunos
					int idade = rs.getInt("idade"); // Puxa a Idade dos alunos
					
					System.out.println("ID: " +id+ ", Nome: " +nome+ ", Idade: " +idade); // Exibe os dados da consulta
				}
			} catch (SQLException e) { // Ação para tratat exceções no banco de dados
				System.err.println("Erro ao ler dados: " + e.getMessage()); // Caso ocorra um erro na leitura dos dados, o sistema informará
			} finally { // Garante que o código será executado independentemente do sucesso ou falha da consulta
				try {
					if (conexao !=null) conexao.close(); // Se a conexão não for nula, será fechada 
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexão: " + e.getMessage()); // Exibe uma mensagem de erro caso ocorra um erro ao tentar fechar a conexão
				}
			}
		
		}
	}
	
}
