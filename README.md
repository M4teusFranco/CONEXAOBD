# Sistema de Manipulação de Dados com JDBC em Java

### 📋 Descrição do Projeto

Este projeto é um sistema de linha de comando em Java que realiza operações básicas de banco de dados utilizando JDBC.

#### Funcionalidades principais:

- ConexaoDB: Estabelece a conexão com o banco de dados.
- Main: Interface principal que oferece um menu interativo com as opções disponíveis.
- InserirDados: Adiciona os registros ao banco.
- AtualizarDados: Atualiza os registros existentes no banco.
- DeletarDados: Remove registros do banco.
- LerDados: Exibe os registros contidos no banco.

### 🔧 Pré-requisitos

- Java JDK 8 ou superior
- Banco de dados relacional (ex: MySQL, PostgreSQL, SQLite)
- Driver JDBC apropriado (ex: mysql-connector-java.jar)
- IDE Java (Eclipse, IntelliJ, etc.)

### 🚀 Instalação e execução

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/CONEXAODB
```

2. Importe o projeto no Eclipse:
- File → Import → Existing Projects into Workspace
- Selecione a pasta do projeto clonado

3. Adicione o driver JDBC ao classpath do projeto.

4. Configure a URL de conexão, usuário e senha em ConexaoDB.java:

```
private static final String URL = "jdbc:mysql://localhost:3306/aula_java_db";
private static final String USUARIO = "root"
private static final String SENHA = ""
```

5. Execute a classe Main.java e siga as instruções no terminal.

### 🛠️ Funcionalidades Implementadas

- Conexão com banco de dados via JPA
- Menu interativo via console
- Adição de registros, que cria um ID
- Atualização de registros por ID
- Remoção de registros por ID
- Leitura dos registros

### 📝 Exemplo de saída

#### Interface Principal

![image](https://github.com/user-attachments/assets/dce48d47-cd35-47fb-9c52-747bbd518160)
![image](https://github.com/user-attachments/assets/3a432b24-1059-4fd3-a0f9-abdeb5a711e4)


#### Inserção de Aluno

![image](https://github.com/user-attachments/assets/d31687ff-3128-4aed-ade0-9d2b48c1477d)
![image](https://github.com/user-attachments/assets/158724cd-3bb2-4247-ace4-4fcd8dcce2cf)


#### Atualização de Aluno

![image](https://github.com/user-attachments/assets/8f6a443c-1369-4ada-9fef-4e3822783ad3)
![image](https://github.com/user-attachments/assets/10b60ea0-de75-4e91-bc99-261f340824cb)


#### Remoção de Aluno

![image](https://github.com/user-attachments/assets/ef35c8b5-eb32-4f65-a9c9-ff753bbe160e)
![image](https://github.com/user-attachments/assets/da71e9a1-072b-4b62-b697-f06576533eb7)


#### Leitura de registros de Alunos
  
![image](https://github.com/user-attachments/assets/3e0ce0ec-c5d9-4d72-8ac7-9312538377fc)
![image](https://github.com/user-attachments/assets/bea4a433-371c-4f62-a3a0-6f0814f6d0ee)


#### Sair

![image](https://github.com/user-attachments/assets/bdc5ae56-18e5-4a30-ad5f-2ef4bb430f50)


## ✒️ Autores

* **Mateus Franco Bezerra** - *Trabalho Inicial* - CONEXAOBD
