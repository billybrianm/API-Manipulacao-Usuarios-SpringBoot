# Back-end Challenge 🏅 2021
Desafio de desenvolvimento de sistema back-end para API de manipulação de usuários
### Tecnologias utilizadas

- Java
- Maven
- Spring Boot
	- Spring Web
	- PostgreSQL para Spring
	- Hibernate JPA
- JUnit 4
- Banco de dados PostgreSQL
- Docker
- Documentação completa em OpenAPI 3.0

### Como instalar e utilizar o projeto
**Sem utilizar Docker:**

1- Clone o repositório para uma pasta local

2- Importe o projeto como um "Projeto Existente Maven" na sua IDE de preferência

3- Acesse o diretório do projeto pelo terminal e utilize o seguinte comando para iniciar:

`./mvnw spring-boot:run`

Ou, se preferir, acesse o arquivo **UsuariosApiApplication.java** e rode a função *main* como *Java Application*.

**Utilizando Docker:**

1- Clone o repositório para uma pasta local

2- Acesse o diretório através do terminal

3- Construa o Dockerfile utilizando o seguinte comando:

`docker build -t springio/usuarios-api-docker .`

Este comando constrói uma imagem e coloca sua tag como `springio/usuarios-api-docker`.

4- Rode a imagem através do comando:

`docker run -p 8080:8080 springio/usuarios-api-docker`

O projeto será compilado pelo maven, e então irá rodar e abrir na porta 8080.

Por fim, acesse a url `http://localhost:8080/`.
