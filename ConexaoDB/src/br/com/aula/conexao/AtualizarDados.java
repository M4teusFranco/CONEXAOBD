package br.com.aula.conexao; // Esta classe pertence ao pacote br.com.aula.conexao
import java.sql.Connection; //Importação de Classes e Bibliotecas necessárias
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados {
		public static void main (String [] args) {
			Connection conexao = ConexaoDB.conectar(); // Puxa o método Conectar para estabelecer a conexão com o Banco de Dados
			
			// Verifica se a conexão foi feita
		if (conexao != null) {
			// Define a instrução sql para editar os dados na tabela alunos
			String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";
			Scanner scanner = new Scanner (System.in); // Scanner para armazenar o que será digitado pelo usuário
		try { // Realização da edição dos dados no banco de dados 
			System.out.println("Digite o ID do aluno que deseja atualizar"); // Solicita o ID do aluno que será editado
			int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
			scanner.nextLine();
			
			System.out.println("Digite o novo nome do aluno: "); // Solicita a inserção do novo nome
			String nome = scanner.nextLine(); // Armazena o novo nome
			
			System.out.println("Digite a nova idade do aluno: "); // Solicita a inserção da nova idade
			int idade = scanner.nextInt(); // Armazena a nova idade
			
			PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
			stmt.setString(1, nome); // Substitui o primeiro (?) pelo novo nome informado
			stmt.setInt(2, idade); // Substitui o segundo (?) pela nova idade informada
			stmt.setInt(3, id); // Informa o terceiro (?), o ID
			int rowsUpdated = stmt.executeUpdate(); // Executa a instrução
			
			if (rowsUpdated > 0 ) { 
				System.out.println("Registro atualizado com sucesso!"); // Se pelo menos 1 registro for alterado, o sistema informará que a operação ocorreu com sucesso
			} else {
				System.err.println("Nenhum registro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
			}
		} catch (SQLException e) {
				System.out.println("Erro ao atualizar dados:" + e.getMessage()); // Informa o fracasso ao tentar editar algum registro do banco de dados
			} finally { // Garante que o código será executado independentemente do sucesso ou falha da inserção
				try {
					if (conexao != null) conexao.close(); // Se a conexão não for nula, será fechada 
				} catch (SQLException e) {
					System.out.println("Erro ao fechar conexão: " + e.getMessage()); // Exibe uma mensagem de erro caso ocorra um erro ao tentar fechar a conexão
				}
				scanner.close(); // Fecha o scanner
			}
		}
	}
}
