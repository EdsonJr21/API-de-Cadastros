# API de Cadastro de Médicos

Este projeto é uma API construída com Spring Boot para gerenciar o cadastro de médicos e pacientes, incluindo dados pessoais como endereço e especialidade médica. A API conta com mecanismos de autenticação, controle de acesso e boas práticas de desenvolvimento, garantindo segurança e eficiência.

## Funcionalidades do Sistema

### Médicos
- **Cadastro de Médicos**  
  Informações obrigatórias: Nome, E-mail, Telefone, CRM, Especialidade (Ortopedia, Cardiologia, Ginecologia ou Dermatologia), Endereço (logradouro, bairro, cidade, UF e CEP).  
  Opcional: Número e complemento do endereço.

- **Listagem de Médicos**  
  Exibe: Nome, E-mail, CRM, Especialidade.  
  Ordenação: Crescente pelo nome.  
  Paginação: 10 registros por página.

- **Atualização de Médicos**  
  Permitido atualizar: Nome, Telefone, Endereço.  
  Restrições: Não é permitido alterar E-mail, CRM ou Especialidade.

- **Exclusão de Médicos**  
  Exclusão lógica: Médico é marcado como "inativo".

### Pacientes
- **Cadastro de Pacientes**  
  Informações obrigatórias: Nome, E-mail, Telefone, CPF, Endereço (logradouro, bairro, cidade, UF e CEP).  
  Opcional: Número e complemento do endereço.

- **Listagem de Pacientes**  
  Exibe: Nome, E-mail, CPF.  
  Ordenação: Crescente pelo nome.  
  Paginação: 10 registros por página.

- **Atualização de Pacientes**  
  Permitido atualizar: Nome, Telefone, Endereço.  
  Restrições: Não é permitido alterar E-mail ou CPF.

- **Exclusão de Pacientes**  
  Exclusão lógica: Paciente é marcado como "inativo".

### Agendamento de Consultas
- **Agendamento de Consultas**  
  Permite o agendamento de consultas entre médicos e pacientes, com dados obrigatórios como data, hora e especialidade.

- **Cancelamento de Consultas**  
  Permite o cancelamento de consultas previamente agendadas.

### Funcionalidades Adicionais
- **Isolamento de Códigos de Regras de Negócio**: As regras de negócio foram isoladas em camadas distintas para facilitar manutenção e testes.
- **Princípios SOLID**: O código segue os princípios SOLID para garantir um design limpo e escalável.
- **Documentação da API (OpenAPI/Swagger)**: A API está documentada usando o Swagger, seguindo o padrão OpenAPI para facilitar o uso e integração.
- **Testes Automatizados**: Foram implementados testes automatizados para garantir o bom funcionamento da aplicação.
- **Build do Projeto**: O projeto foi configurado para realizar builds automatizados.
- **Variáveis de Ambiente e Deploy**: Utilização de variáveis de ambiente para configurações e preparação para o deploy.

## Tecnologias
- Java 17
- Spring Boot
- Maven
- MySQL
- Hibernate
- Flyway
- Lombok
- Postman (para testes de API)
- Swagger (para documentação da API)
