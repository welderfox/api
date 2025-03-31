# 🚀 API de Equipamentos e Manutenções

## 📌 Instruções para rodar o projeto localmente

### 1️⃣ **Pré-requisitos**
- Java 8 ou superior
- Maven instalado
- PostgreSQL instalado e rodando
- Node.js instalado (para rodar o front-end)

### 2️⃣ **Configurar o banco de dados**
1. Crie um banco de dados no PostgreSQL:
   ```sql
   CREATE DATABASE DbApi;
   ```
2. Execute o script SQL para criar as tabelas e popular com dados iniciais, ou ao **rodar a Api o banco sera populado automaticamente.**
 Caso não prefira executar os scripts, antes de executar o build abra o arquivo "**application.properties**" e
 altere essa linha no arquivo "spring.jpa.hibernate.ddl-auto=create" para --> spring.jpa.hibernate.ddl-auto=none


### 3️⃣ **Configurar o projeto**
1. Clone o repositório do projeto:
   ```sh
   git clone https://github.com/welderfox/api.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd seu-repositorio
   ```
3. Configure o arquivo `application.properties` com suas credenciais do PostgreSQL.

### 4️⃣ **Rodar a API**
1. Compile e gere o `.jar` do projeto:
   ```sh
   mvn clean package
   ```
2. Execute o `.jar` gerado:
   ```sh
   java -jar target/api-0.0.1-SNAPSHOT.jar
   ```
3. A API estará disponível em: `http://localhost:8080`

### 5️⃣ **Rodar o Front-end**
1. Clone o repositório do projeto:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Vá até a pasta do front-end:
   ```sh
   cd equipamentos-manutencao
   ```
3. Instale as dependências:
   ```sh
   npm install
   ```
4. Execute o projeto:
   ```sh
   npm start
   ```
5. O front-end estará disponível em: `http://localhost:3000`

---

## 📌 Link ou Arquivo da Collection do Postman
[Baixar Collection do Postman](https://drive.google.com/file/d/1jwykRzQXapOz81ED6Q9vRXxY0n-suM1Y/view?usp=sharing)

## 📌 Link ou Arquivo da Collection do Insomnia
[Baixar Collection do Insomnia](https://drive.google.com/file/d/1gAhYTdJtmbUCb-avQd_wwM5bo7YxABWG/view?usp=sharing)

## 📌 Link para Download do Arquivo SQL
[Baixar Script SQL](https://drive.google.com/file/d/18Sfd-2lKCrvbCB-wKoifgqy-iToE1Eim/view?usp=sharing)

---

## 📌 Decisões Técnicas
- **Spring Boot**: Utilizado para construir a API de forma rápida e estruturada, tomei essa decisão pois estou usando para estudos.
- **PostgreSQL**: Banco de dados relacional escolhido pela sua robustez e por ter conhecimento com o mesmo pois ja trabalhei usando o mesmo.
- **ReactJS + Material UI**: Para criar um front-end, apesar de não dominar totalmente esta tecnologia ja trabalhei com ela criando projetos simples.
- **Tomei a decisão de implementar o relatorio no Bakc-end, caso ficasse imcompleto o Front-end, por este motivo exitem dois endponits para relatorio um deles retornando pdf.
---

📌 **Dúvidas?** Entre em contato!

🚀 **Desenvolvido por Welder Junio**

