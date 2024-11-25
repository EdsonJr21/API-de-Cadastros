# API de Cadastro de Médicos

> **Status do Projeto**: Em desenvolvimento 🚧

Este projeto é uma API construída com Spring Boot para gerenciar o cadastro de médicos e pacientes, incluindo dados pessoais como endereço e especialidade médica. A API conta com mecanismos de autenticação, controle de acesso e boas práticas de desenvolvimento, garantindo segurança e eficiência. Além disso, funcionalidades como agendamento e cancelamento de consultas estão previstas para futuras implementações.

# Funcionalidades do Sistema

## Médicos

### Cadastro de Médicos
- **Informações obrigatórias**: Nome, E-mail, Telefone, CRM, Especialidade (Ortopedia, Cardiologia, Ginecologia ou Dermatologia), Endereço (logradouro, bairro, cidade, UF e CEP).
- **Opcional**: Número e complemento do endereço.

### Listagem de Médicos
- Exibe: Nome, E-mail, CRM, Especialidade.
- Ordenação: Crescente pelo nome.
- Paginação: 10 registros por página.

### Atualização de Médicos
- **Permitido atualizar**: Nome, Telefone, Endereço.
- **Restrições**: Não é permitido alterar E-mail, CRM ou Especialidade.

### Exclusão de Médicos
- Exclusão lógica: Médico é marcado como "inativo".

---

## Pacientes

### Cadastro de Pacientes
- **Informações obrigatórias**: Nome, E-mail, Telefone, CPF, Endereço (logradouro, bairro, cidade, UF e CEP).
- **Opcional**: Número e complemento do endereço.

### Listagem de Pacientes
- Exibe: Nome, E-mail, CPF.
- Ordenação: Crescente pelo nome.
- Paginação: 10 registros por página.

### Atualização de Pacientes
- **Permitido atualizar**: Nome, Telefone, Endereço.
- **Restrições**: Não é permitido alterar E-mail ou CPF.

### Exclusão de Pacientes
- Exclusão lógica: Paciente é marcado como "inativo".

## 🛠 Tecnologias
- **Java 17**
- **Spring Boot**
- **Maven**
- **MySQL**
- **Hibernate**
- **Flyway**
- **Lombok**
- **Postman** (para testes de API)