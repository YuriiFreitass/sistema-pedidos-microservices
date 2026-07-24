# Cliente Service

Microsserviço desenvolvido em **Java 21** e **Spring Boot** responsável pelo gerenciamento de clientes.

O projeto foi desenvolvido seguindo boas práticas de desenvolvimento Backend, utilizando arquitetura em camadas, DTOs, MapStruct, Bean Validation, tratamento global de exceções, autenticação com Spring Security (HTTP Basic) e documentação automática com OpenAPI/Swagger.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate
- MySQL
- MapStruct
- Bean Validation (Jakarta Validation)
- Lombok
- OpenAPI / Swagger
- Docker
- Maven

---

# Arquitetura

O projeto segue a arquitetura em camadas (Layered Architecture):

```
Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
Banco de Dados
```

Cada camada possui uma responsabilidade específica:

- **Controller:** recebe e responde às requisições HTTP.
- **Service:** concentra as regras de negócio.
- **Repository:** realiza o acesso ao banco de dados.
- **Entity:** representa as tabelas do banco.
- **DTO:** utilizado para entrada e saída de dados da API.
- **Mapper:** converte DTOs em entidades e vice-versa utilizando MapStruct.

---

# Funcionalidades

- Cadastro de clientes
- Listagem paginada de clientes
- Busca de cliente por ID
- Atualização de clientes
- Exclusão de clientes
- Validação dos dados recebidos
- Tratamento global de exceções
- Proteção dos endpoints com Spring Security
- Documentação automática com Swagger/OpenAPI

---

# Estrutura do Projeto

```
src
└── main
    ├── config
    ├── controller
    ├── dto
    ├── entity
    ├── exception
    ├── mapper
    ├── repository
    ├── service
    └── security
```

---

# Segurança

A aplicação utiliza **Spring Security** para proteger todos os endpoints através de autenticação **HTTP Basic**.

Durante o desenvolvimento foi adotado um **usuário configurado em memória (InMemoryUserDetailsManager)**, permitindo proteger a API sem a necessidade de um banco de usuários.

Essa abordagem foi utilizada por ser simples e suficiente para o escopo atual do projeto.

A autenticação baseada em **JWT**, juntamente com persistência de usuários e autorização por papéis (roles), será implementada em um projeto dedicado ao estudo de autenticação com Spring Security.

---

# BCrypt

O projeto possui uma classe de teste chamada **GerarSenhaHash**, utilizada para gerar hashes utilizando o algoritmo **BCrypt**.

Esses hashes são utilizados na configuração do usuário em memória do Spring Security, evitando o armazenamento de senhas em texto puro.

---

# Como executar o projeto

## 1. Clone o repositório

```bash
git clone https://github.com/YuriiFreitass/cliente-service
```

---

## 2. Configure as variáveis de ambiente

Crie um arquivo `.env` baseado no arquivo `.env.example`.

---

## 3. Inicie o banco de dados

```bash
docker compose up -d
```

---

## 4. Execute a aplicação

Utilizando Maven:

```bash
./mvnw spring-boot:run
```

Ou execute diretamente pela sua IDE.

---

# Banco de Dados

O projeto utiliza **MySQL** como banco de dados relacional.

As configurações da aplicação são realizadas através do arquivo:

```
application.yml
```

utilizando variáveis de ambiente.

---

# Documentação da API

Após iniciar a aplicação, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

# Autenticação

Como os endpoints estão protegidos pelo Spring Security, é necessário informar as credenciais configuradas na aplicação para acessar a API.

No Swagger, clique no botão **Authorize** e informe o usuário e a senha configurados.

Também é possível utilizar ferramentas como Postman ou Insomnia enviando as credenciais através de **HTTP Basic Authentication**.

---

# Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | `/v1/clientes` | Lista clientes |
| GET | `/v1/clientes/{id}` | Busca cliente por ID |
| POST | `/v1/clientes` | Cadastra cliente |
| PUT | `/v1/clientes/{id}` | Atualiza cliente |
| DELETE | `/v1/clientes/{id}` | Remove cliente |

---

# Boas práticas aplicadas

- Arquitetura em camadas (Layered Architecture)
- Separação entre Entity e DTO
- MapStruct para mapeamento entre objetos
- Bean Validation para validação dos dados
- Tratamento global de exceções
- Spring Security para proteção dos endpoints
- Utilização de BCrypt para armazenamento seguro de senhas
- Código organizado seguindo princípios de Clean Code
- Documentação automática com OpenAPI/Swagger

---


# Autor

Desenvolvido por **Yuri Freitas** como projeto de estudos para aprofundamento em Java Backend utilizando Spring Boot e boas práticas de desenvolvimento.
