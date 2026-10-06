# Academia - API REST com Spring Boot

Aplicação web simples de gerenciamento de uma academia, com operações de CRUD em entidades inter-relacionadas. Projeto acadêmico da disciplina de Spring Boot (Unifacisa).

## Tecnologias

- Java 26
- Spring Boot 4.1.1 (Spring Web MVC e Spring Data JPA)
- Hibernate 7
- MySQL 8
- Lombok
- Maven

## Entidades e relacionamentos

| Entidade | Atributos principais |
|---|---|
| Aluno | idAluno, nome, telefone, email |
| Instrutor | idInstrutor, nome, cref, especialidade, telefone |
| Ficha | idFicha, peso, altura, objetivo, dataAvaliacao |
| Treino | idTreino, nome, descricao, grupoMuscular, duracaoMinutos |

| Relacionamento | Tipo | Detalhe |
|---|---|---|
| Aluno ↔ Ficha | Um-para-Um | cada aluno tem uma ficha; a chave estrangeira fica em `fichas` |
| Instrutor → Aluno | Um-para-Muitos | um instrutor acompanha vários alunos |
| Aluno → Instrutor | Muitos-para-Um | vários alunos pertencem a um instrutor; a chave estrangeira fica em `alunos` |
| Aluno ↔ Treino | Muitos-para-Muitos | tabela intermediária `treino_aluno`; `Treino` é o lado dono |

## Como executar

1. Instale o Java, o Maven (ou use o `mvnw` do projeto) e o MySQL.
2. Crie o banco de dados:

```sql
CREATE DATABASE academia;
```

3. Em `src/main/resources/application.properties`, configure a conexão com o seu MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/academia
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

4. Rode a aplicação:

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Endpoints

### Alunos (`/alunos`)

| Método | URL | Descrição |
|---|---|---|
| GET | `/alunos` | lista todos os alunos |
| POST | `/alunos` | cadastra um aluno |
| PUT | `/alunos/{idAluno}` | atualiza um aluno |
| DELETE | `/alunos/{idAluno}` | remove um aluno |

### Instrutores (`/instrutores`)

| Método | URL | Descrição |
|---|---|---|
| GET | `/instrutores` | lista todos os instrutores |
| POST | `/instrutores` | cadastra um instrutor |
| PUT | `/instrutores/{idInstrutor}` | atualiza um instrutor |
| DELETE | `/instrutores/{idInstrutor}` | remove um instrutor |

### Fichas (`/fichas`)

| Método | URL | Descrição |
|---|---|---|
| GET | `/fichas` | lista todas as fichas |
| POST | `/fichas` | cadastra uma ficha |
| PUT | `/fichas/{idFicha}` | atualiza uma ficha |
| DELETE | `/fichas/{idFicha}` | remove uma ficha |

### Treinos (`/treinos`)

| Método | URL | Descrição |
|---|---|---|
| GET | `/treinos` | lista todos os treinos |
| POST | `/treinos` | cadastra um treino |
| PUT | `/treinos/{idTreino}` | atualiza um treino |
| DELETE | `/treinos/{idTreino}` | remove um treino |
| POST | `/treinos/{idTreino}/alunos/{idAluno}` | liga um aluno a um treino |
| DELETE | `/treinos/{idTreino}/alunos/{idAluno}` | desliga um aluno de um treino |

## Exemplos de JSON

Instrutor:

```json
{
  "nome": "Carlos",
  "cref": "123456-G/PB",
  "especialidade": "Musculação",
  "telefone": "83999990000"
}
```

Aluno (ligado a um instrutor):

```json
{
  "nome": "João",
  "telefone": "83988880000",
  "email": "joao@email.com",
  "instrutor": { "idInstrutor": 1 }
}
```

Ficha (ligada a um aluno):

```json
{
  "peso": 78.5,
  "altura": 1.75,
  "objetivo": "Hipertrofia",
  "dataAvaliacao": "2026-10-05T10:00:00",
  "aluno": { "idAluno": 1 }
}
```

Treino:

```json
{
  "nome": "Treino A",
  "descricao": "Peito e tríceps",
  "grupoMuscular": "Peito",
  "duracaoMinutos": 60
}
```

## Ordem sugerida para testar

1. Criar o instrutor
2. Criar o aluno, informando o instrutor
3. Criar a ficha, informando o aluno
4. Criar o treino
5. Ligar o aluno ao treino com `POST /treinos/1/alunos/1`
6. Conferir com `GET /alunos`

## Estrutura do projeto

```
src/main/java/com/unifacisa/Academia
├── controller    # endpoints da API
├── service       # regras de negócio
├── repositories  # acesso ao banco (Spring Data JPA)
└── entities      # entidades e relacionamentos JPA
```

## Autor

Arthur Morais - [github.com/arthur-moraiss](https://github.com/arthur-moraiss)
