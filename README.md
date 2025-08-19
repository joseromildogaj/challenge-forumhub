# 📚 ForumHub API

![Java](https://img.shields.io/badge/Java-17%2B-blue?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-4.0-red?style=for-the-badge&logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON-Web-Tokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

---

## 📖 Sobre o Projeto

O **ForumHub** é uma API RESTful desenvolvida como parte do *Challenge Back End* da **Oracle Next Education (ONE)** em parceria com a **Alura**. 

O projeto foi construído seguindo as melhores práticas de desenvolvimento, incluindo arquitetura REST, segurança baseada em tokens JWT, versionamento de banco com Flyway e documentação completa com Swagger.

---

## ✨ Principais Funcionalidades

- **Sistema de Login JWT**: Autenticação stateless com tokens seguros
- **Proteção de Endpoints**: Acesso baseado em permissões
- **CRUD Completo**: Criar, listar, detalhar, atualizar e excluir tópicos
- **Top 10**: Listagem dos tópicos mais relevantes

### 📊 Recursos Adicionais
- **Validações Robustas**: Bean Validation em todos os inputs
- **Tratamento de Erros**: Respostas padronizadas e informativas
- **Documentação Interativa**: Interface Swagger para testes
- **Migrations Automáticas**: Controle de versão do banco

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+** - Linguagem de programação principal
- **Spring Boot 3.x** - Framework para aplicações web
- **Spring Security** - Controle de autenticação e autorização
- **Spring Data JPA** - Persistência de dados e ORM
- **Maven** - Gerenciamento de dependências e build
- **MySQL** - Banco de dados relacional
- **Flyway** - Versionamento e migração de schema
- **JWT** - Tokens seguros para autenticação
- **Lombok** - Redução de código boilerplate
- **SpringDoc (Swagger)** - Documentação automática da API

---

## 🚀 Como Executar o Projeto

### ✅ Pré-requisitos

- Java JDK 17 ou superior
- Maven 3.8 ou superior
- MySQL Server

### 📦 Instalação

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/joseromildogaj/challenge-forumhub.git
   cd forumhub
   ```

2. **Configure o banco de dados:**
   ```sql
   CREATE DATABASE forumhub;
   ```

3. **Configure as variáveis de ambiente:**
   ```properties
   # application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   spring.flyway.enabled=true
   ```

4. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a aplicação:**
   - API: `http://localhost:8080`
   - Documentação: `http://localhost:8080/swagger-ui.html`

---

## 📚 Documentação da API

### 🔐 Autenticação

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/login` | Login e geração de token JWT| 

### 📝 Tópicos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/topicos` | Listar tópicos |
| GET | `/topicos/{id}` | Detalhar tópico específico |
| POST | `/topicos` | Criar novo tópico |
| PUT | `/topicos/{id}` | Atualizar tópico |
| DELETE | `/topicos/{id}` | Excluir tópico |
| GET | `/topicos/top10` | Top 10 tópicos |

### 👤 Usuários

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/usuarios` | Listar usuários |
| GET | `/usuarios/{id}` | Perfil do usuário |
| POST | `/usuarios` | Cadastrar usuário |
| DELETE | `/usuarios/{id}` | Excluir usuário |

### 📚 Cursos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/cursos` | Listar cursos |
| POST | `/cursos` | Criar curso |
| GET | `/cursos/{id}` | Detalhar curso específico |
| DELETE | `/cursos/{id}` | Excluir curso |
| GET | `/cursos/{id}` | Atualizar curso |

---

## 🔒 Segurança

- ✅ Senhas criptografadas com BCrypt
- ✅ Tokens JWT com expiração
- ✅ Validação de entrada em todos endpoints

---

## 🎓 Agradecimentos

<div>

![Oracle ONE](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![Alura](https://img.shields.io/badge/Alura-0078D4?style=for-the-badge&logoColor=white)

Projeto desenvolvido durante o **Challenge Back End** da **Oracle Next Education (ONE)** em parceria com a **Alura**.

</div>

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.


