# API de Tutoria

Este projeto fornece uma API para gerenciar sessões de tutoria, alunos, tutores, agendas e materiais em uma plataforma de tutoria.

## 🚀 Endpoints

### **Agendas**

- **POST /v1/agendas**  
  Cria uma nova agenda (sessão de tutoria).  
  **Resposta:** `201 Created`

- **GET /v1/agendas/{agendaId}**  
  Obtém os detalhes de uma agenda por ID.  
  **Resposta:** `200 OK`, `404 Not Found`

- **GET /v1/agendas/aluno-id/{alunoId}**  
  Obtém todas as agendas de um aluno.  
  **Resposta:** `200 OK`, `204 No Content`

- **GET /v1/agendas/tutor-id/{tutorId}**  
  Obtém todas as agendas de um tutor.  
  **Resposta:** `200 OK`, `204 No Content`

- **GET /v1/agendas/proximos/aluno-id/{alunoId}**  
  Obtém as próximas agendas de um aluno.  
  **Resposta:** `200 OK`

- **GET /v1/agendas/proximos/tutor-id/{tutorId}**  
  Obtém as próximas agendas de um tutor.  
  **Resposta:** `200 OK`

- **GET /v1/agendas**  
  Lista todas as agendas.  
  **Resposta:** `200 OK`

- **PUT /v1/agendas/{agendaId}**  
  Atualiza uma agenda existente.  
  **Resposta:** `204 No Content`

- **DELETE /v1/agendas/{agendaId}**  
  Deleta uma agenda por ID.  
  **Resposta:** `204 No Content`

---

### **Alunos**

- **POST /v1/alunos**  
  Cria um novo aluno.  
  **Resposta:** `201 Created`

- **GET /v1/alunos/{alunoId}**  
  Obtém os detalhes de um aluno por ID.  
  **Resposta:** `200 OK`, `404 Not Found`

- **GET /v1/alunos**  
  Lista todos os alunos.  
  **Resposta:** `200 OK`

- **PUT /v1/alunos/{alunoId}**  
  Atualiza os dados de um aluno.  
  **Resposta:** `204 No Content`

- **DELETE /v1/alunos/{alunoId}**  
  Deleta um aluno por ID.  
  **Resposta:** `204 No Content`

---

### **Materiais**

- **POST /v1/materiais**  
  Cria um novo material.  
  **Resposta:** `201 Created`

- **GET /v1/materiais/{materialId}**  
  Obtém os detalhes de um material por ID.  
  **Resposta:** `200 OK`, `404 Not Found`

- **GET /v1/materiais**  
  Lista todos os materiais.  
  **Resposta:** `200 OK`

- **PUT /v1/materiais/{materialId}**  
  Atualiza um material existente.  
  **Resposta:** `204 No Content`

- **DELETE /v1/materiais/{materialId}**  
  Deleta um material por ID.  
  **Resposta:** `204 No Content`

---

### **Tutores**

- **POST /v1/tutores**  
  Cria um novo tutor.  
  **Resposta:** `201 Created`

- **GET /v1/tutores/{tutorId}**  
  Obtém os detalhes de um tutor por ID.  
  **Resposta:** `200 OK`, `404 Not Found`

- **GET /v1/tutores**  
  Lista todos os tutores.  
  **Resposta:** `200 OK`

- **PUT /v1/tutores/{tutorId}**  
  Atualiza os dados de um tutor.  
  **Resposta:** `204 No Content`

- **DELETE /v1/tutores/{tutorId}**  
  Deleta um tutor por ID.  
  **Resposta:** `204 No Content`

---

## 🛠 Tecnologias Utilizadas

- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Java**

---

## ⚡ Como Executar

1. Clone o repositório.
2. Construa o projeto usando **Maven** ou **Gradle**.
3. Configure a conexão com o banco de dados em `application.properties`.
4. Execute a aplicação com o comando:
    - **Maven:** `mvn spring-boot:run`
    - **Gradle:** `gradle bootRun`

---

## 📋 Observações

- A API utiliza **DTOs** (Objetos de Transferência de Dados) para entrada e saída de dados.
- Todos os endpoints retornam os códigos de status HTTP apropriados com base no resultado da requisição.
