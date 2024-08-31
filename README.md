<center>
  <p align="center">
    <img src="https://icon-library.com/images/java-icon-png/java-icon-png-15.jpg"  width="150" />
  </p>  
  <h1 align="center">🚀 API: Administração do transito</h1>
  <p align="center">
    Uma pequena aplicação para administração do transito pelo ente publico.
  </p>
</center>
<br />

## Sumário

- [Descrição](#descrição)
- [Requisitos](#requisitos)
- [Instalação](#instalação)
- [Uso](#uso)
- [Diagrama UML](#diagrama-uml)
- [Recursos](#recursos-crud)
- [Licença](#licença)
- [Contato](#contato)

## Descrição

O `transito-api` é uma aplicação Java baseada em Spring Boot que fornece uma API para gerenciar multas de trânsito para prefeituras. O projeto utiliza:

- **Spring Boot** para criar uma aplicação robusta e fácil de configurar.
- **MariaDB** como banco de dados relacional.
- **Flyway** para gerenciamento de migrações de banco de dados.
- **Lombok** para reduzir o código boilerplate.

## Requisitos

Antes de começar, verifique se você tem os seguintes softwares instalados:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Apache Maven 3.6 ou superior](https://maven.apache.org/download.cgi)
- [MariaDB](https://mariadb.org/download/)

## Instalação

Siga os passos abaixo para configurar o projeto:

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/usuario/transito-api.git
   cd transito-api
    ```
2. **Compile o projeto e baixe as dependências:**

   ```bash
   mvn clean install
    ```
3. **Configure o banco de dados:**

    Edite o arquivo src/main/resources/application.properties para adicionar suas configurações de banco de dados:
   ```bash
   spring.application.name=nome-da-aplicacao
   spring.datasource.url=jdbc:mariadb://localhost:3306/transito
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
    ```

4. **Aplique as migrações do Flyway:**

    O Flyway será executado automaticamente durante a inicialização da aplicação para aplicar as migrações do banco de dados.


## Uso
Para iniciar a aplicação, execute:

   ```bash
   mvn spring-boot:run
   ```

A API estará disponível em http://localhost:8080.

## Recursos

A API `transito-api` oferece endpoints para realizar operações CRUD nas entidades `Proprietario` e `Veiculo`. Aqui estão os detalhes de cada recurso:

### Proprietário

#### Criar Proprietário

- **Endpoint:** `POST /api/proprietarios`
- **Descrição:** Adiciona um novo proprietário.
- **Request Body:**
  ```json
  {
    "nome": "Nome do Proprietário",
    "email": "email@dominio.com",
    "telefone": "123456789"
  }
- **Resposta:**
  - **Código de Sucesso:** 201 Created 
  - **Corpo da Resposta:**
  ```json
  {
   "id": 1,
   "nome": "Nome do Proprietário",
   "email": "email@dominio.com",
   "telefone": "123456789"
  }

#### Buscar Proprietário por ID

- **Endpoint:** `GET /api/proprietarios/{id}`
- **Descrição:** Retorna os detalhes de um proprietário pelo ID.
- **Parâmetros de URL:**
    - id (Long): ID do proprietário.
- **Resposta:**
    - **Código de Sucesso:** 200 OK
    - **Corpo da Resposta:**
  ```json
  {
   "id": 1,
   "nome": "Nome do Proprietário",
   "email": "email@dominio.com",
   "telefone": "123456789"
  }
  ```
  - **Código de Erro:** 404 Not Found (se o proprietário não for encontrado).

#### Atualizar Proprietário
- **Endpoint:** `PUT /api/proprietarios/{id}`
- **Descrição:** Atualiza as informações de um proprietário.
- **Parâmetros de URL:**
   - id (Long): ID do proprietário.
- **Request Body:**
  ```json
  {
    "nome": "Nome Atualizado",
    "email": "novoemail@dominio.com",
    "telefone": "987654321"
  }
  ```
- **Resposta:**
    - **Código de Sucesso:** 200 OK
    - **Corpo da Resposta:**
  ```json
  {
   "id": 1,
   "nome": "Nome Atualizado",
   "email": "novoemail@dominio.com",
   "telefone": "987654321"
  }
  ```
    - **Código de Erro:** 404 Not Found (se o proprietário não for encontrado).