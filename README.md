# Registro De Livro

API REST desenvolvida para praticar Java e Spring Boot, com o código organizado em camadas (controller, service, repository) seguindo boas práticas de desenvolvimento. Os livros ficam salvos em um banco de dados PostgreSQL.

## Tecnologias

- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Funcionalidades

- Cadastrar, consultar, editar e excluir livros (CRUD)
- Filtrar livros por autor

## Endpoints

| Método | Rota                     | Descrição               |
| ------ | ------------------------ | ----------------------- |
| GET    | `/book`                | Lista todos os livros   |
| GET    | `/book/{id}`           | Busca um livro pelo ID  |
| POST   | `/book`                | Cadastra um livro       |
| PUT    | `/book/{id}`           | Atualiza um livro       |
| DELETE | `/book/{id}`           | Exclui um livro         |
| GET| `/author/{id}/books`| Retorna os Livro por Autor|
| POST| `/author`| Cadastra um autor|
| GET| `/author`| Lista todos os autores|


## 🚀 Como Rodar

**Pré-requisitos:** Java 25 e PostgreSQL instalados.

1. Clone o repositório:

```bash
git clone git@github.com:freitasscaio/book-registration.git
cd book-registration
```

2. Crie um banco no PostgreSQL e configure o acesso em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. Rode a aplicação:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## O que aprendi

- Organizar um projeto Spring Boot em camadas
- Fazer a conexão com o PostgreSQL usando JPA
- Criar endpoints REST para um CRUD completo