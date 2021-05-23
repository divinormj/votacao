# Votação
Sistema de votação

Prova técnica com objetivo de desenvolver uma API para votação de pautas de uma cooperativa.
Seguindo a definição em https://github.com/rh-southsystem/desafio-back-votos

Desenvolvido utilizando a IDE Spring Tool Suite 4, linguagem Java (11), framework Spring Boot, banco MySql e JUnit.
Os dados de conexão com o banco estão no arquivo application.yml. 
Para versionamento de schemas de banco de dados foi usado o Flyway. Um script para popular as tabelas é executado ao iniciar a aplicação, afterMigrate.sql.

Os testes usam outro banco com a conexão definida em application-test.yml, sem preenchimento inicial de tabelas.

Para documentação da API foi utilizado o padrão OpenApi, com Swagger UI e SpringFox.
Com a aplicação iniciada acessar localhost:8080/swagger-ui.html
A estrutura do projeto possui 3 pacotes principais:

. api: recursos disponiveis aos consumidores.

. domain: classes de domínio da aplicação.

. infrastructure: implementação de interfaces, e demais classes que estão relacionadas com a estrutura/tecnologia utilizada, que podem mudar sem alterar a lógica de negócio.

A API usa versionamento por URI. 
Por considerar mais simples para o consumidor e ficar claro qual versão está sendo usada pelo recurso, olhando apenas a URI.
