package br.com.aula.conexao; // Esta classe pertence ao pacote br.com.aula.conexao
import java.sql.Connection; //Importação de Classes e Bibliotecas necessárias
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//Criação da classe DeletarDados (Remoção de registros no Dados no Banco)
public class DeletarDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoDB.conectar(); // Puxa o método Conectar para estabelecer a conexão com o Banco de Dados
		
		// Verifica se a conexão foi feita
		if (conexao != null) {
			// Define a instrução sql para deletar os dados na tabela alunos
			String sql = "DELETE FROM alunos WHERE id=?";
			Scanner scanner = new Scanner(System.in); // Scanner para armazenar o que será digitado pelo usuário
		
		try { // Realização da remoção dos dados no banco de dados
			System.out.println("Digite o ID do aluno que deseja deletar: "); // Solicita o ID do aluno que será removido
			int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
			
			PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
			stmt.setInt(1, id); // Substitui o (?) pelo ID informado
			
			int rowsDeleted = stmt.executeUpdate(); // Executa a instrução
			
			if (rowsDeleted >0) { 
				System.out.println("Registro deletado com sucesso!"); // Se pelo menos 1 registro for deletado, o sistema informará que a operação ocorreu com sucesso
			} else {		
				System.out.println("Nenhum reistro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
			}
		} catch (SQLException e) {
			System.err.println("Erro ao deletar dados: " + e.getMessage()); //Infoma o fracasso ao tentar remover um registro
		} finally { // Garante que o código será executado independentemente do sucesso ou falha da inserção
			try {
				if (conexao != null) conexao.close(); // Se a conexão não for nula, será fechada 
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão: " + e.getMessage()); // Exibe uma mensagem de erro caso ocorra um erro ao tentar fechar a conexão
			}
			scanner.close(); // Fecha o scanner
			}	
		}
	}
}

