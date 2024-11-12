package main;
import java.util.HashSet; //Importação de Classes e Bibliotecas necessárias para funcionalidade do código
import java.nio.file.spi.FileSystemProvider;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.aula.conexao.*;
	
// Criação da Classe Main da interface
public class Main {
	
		public static void main(String[] args) {
			Connection conexao = ConexaoDB.conectar(); // Puxa o método Conectar para estabelecer a conexão com o Banco de Dados
				
			Scanner scanner = new Scanner (System.in); // Cria o Objeto scanner para receber os números digitado
			Set<String> alunos = new HashSet<>(); // Cria um Set para armazenar nomes de frutas
			
			// Enquanto o usuário digitar os números dentre as opções, a operação continua
			while(true) {
				try {
					// Exibição das opções do Usuário
					System.out.println("\n===== Menu Principal ======\n"); 
					System.out.println("1. Inserir Aluno");
					System.out.println("2. Atualizar Aluno");
					System.out.println("3. Deletar Aluno");
					System.out.println("4. Ler Registros de Alunos");
					System.out.println("0. Sair");
					System.out.println("------------------------------------------------");
					System.out.println("\nEscolha uma opção: ");
					
					int opcao = scanner.nextInt(); // Váriavel que armazenará o número digitado pelo Usuário
					scanner.nextLine(); // Pula de linha após inserção do dígito
					
					// Inicialização do Switch de escolhas do Usuário
					switch(opcao) {
					case 1: // Caso o Usuário escolha a Opção 1 (Inserir Aluno)
					
					// Verifica se a conexão foi feita
					if(conexao != null) {
						// Define a instrução sql para inserir os dados na tabela alunos
						String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
						
						System.out.println("Digite o nome do aluno: "); // Solicita a inserção do nome
						String nome = scanner.nextLine(); // Armazena o nome
						
						System.out.println("Digite a nova idade do aluno: "); // Solicita a inserção da idade
						int idade = scanner.nextInt(); // Armazena a idade
						
						
						try { // Realização da inserção dos dados no banco de dados
							
							PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
							stmt.setString(1, nome); // Substitui o primeiro (?) pelo novo nome informado
							stmt.setInt(2, idade); // Substitui o segundo (?) pela nova idade informada
							int rowsUpdated = stmt.executeUpdate(); // Executa a instrução
							
							System.out.println("Dados inseridos com sucesso!"); // Informa que os dados foram inseridos com sucesso
						} catch (SQLException e ) {
							System.err.println("Erro ao inserir dados: " + e.getMessage()); // Informa que houve um erro na inserção de dados
						}						
					} 	break;

					case 2: // Caso o Usuário escolha a Opção 2 (Atualizar Aluno)
						// Verifica se a conexão foi feita
						if (conexao != null) {
							// Define a instrução sql para editar os dados na tabela alunos
							String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";
						
							System.out.println("Digite o ID do aluno que deseja atualizar"); // Solicita o ID do aluno que será editado
							int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
							scanner.nextLine();
							
							System.out.println("Digite o novo nome do aluno: "); // Solicita a inserção do novo nome
							String nome = scanner.nextLine(); // Armazena o novo nome
							
							System.out.println("Digite a nova idade do aluno: "); // Solicita a inserção da nova idade
							int idade = scanner.nextInt(); // Armazena a nova idade
							
						try { // Realização da edição dos dados no banco de dados 
							
							PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
							stmt.setString(1, nome); // Substitui o primeiro (?) pelo novo nome informado
							stmt.setInt(2, idade); // Substitui o segundo (?) pela nova idade informada
							stmt.setInt(3, id); // Informa o terceiro (?), o ID
							int rowsUpdated = stmt.executeUpdate(); // Executa a instrução e informa quantos registros foram afetados
							
							if (rowsUpdated > 0 ) { 
								System.out.println("Registro atualizado com sucesso!"); // Se pelo menos 1 registro for alterado, o sistema informará que a operação ocorreu com sucesso
							} else {
								System.err.println("Nenhum registro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
							}
						} catch (SQLException e) {
								System.out.println("Erro ao atualizar dados:" + e.getMessage()); // Informa o fracasso ao tentar editar algum registro do banco de dados
							} 
						} break;
					
					case 3: // Caso o Usuário escolha a Opção 3 (Deletar Aluno)
						// Verifica se a conexão foi feita
						if (conexao != null) {
							// Define a instrução sql para deletar os dados na tabela alunos
							String sql = "DELETE FROM alunos WHERE id=?";
							System.out.println("Digite o ID do aluno que deseja deletar: "); // Solicita o ID do aluno que será removido
							int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
							
						try { // Realização da remoção dos dados no banco de dados
							
							PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
							stmt.setInt(1, id); // Substitui o (?) pelo ID informado
							
							int rowsDeleted = stmt.executeUpdate(); // Executa a instrução e informa quantos registros foram afetados
							
							if (rowsDeleted >0) { 
								System.out.println("Registro deletado com sucesso!"); // Se pelo menos 1 registro for deletado, o sistema informará que a operação ocorreu com sucesso
							} else {		
								System.out.println("Nenhum reistro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
							}
						} catch (SQLException e) {
							System.err.println("Erro ao deletar dados: " + e.getMessage()); //Infoma o fracasso ao tentar remover um registro
						} 	
					} break;
						
						
					case 4: // Caso o Usuário escolha a Opção 4 (Ler Registros de Alunos)
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
							} 
						
						} break;
						
					case 0: // Caso o Usuário queira sair do sistema (Sair)
						System.out.println("Saindo..."); // Mensagem que informa a saída
						scanner.close();
						return; // Encerra o programa
						
					default:
                       System.out.println("Opção inválida. Tente novamente."); // Informa que a opção digitada não existe e solicita uma nova
					}
				} catch (InputMismatchException e) {
	                // Caso o Usuário insira algum tipo de dado incorreto no lugar dos dígitos designidados
					System.out.println("Entrada inválida. Por favor, digite um número.");
					scanner.nextLine();
					}
				}
			}
		}
