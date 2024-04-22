# Teste NTTData

## Tecnologias 
- Java 17
- Spring Boot
- Lombok
- Maven

## Instruções para Executar

Para rodar a aplicação é necessário fazer a build do app com o comando:
**mvn clean package spring-boot:repackage**

Após isso será gerado um arquivo **.jar** dentro da pasta target, navegar até a pasta pelo terminal do windows/linux e executar o comando
'java -jar **nomeDoArquivoGerado.jar**'

Após isso fazer as requisições pelo **Postman**

## Tarefas Bônus
 
- Implementado teste integrado de todos os endpoints

## Observação
A api SWAPI teve seu certificado vencido ontem 21/04/2024 as 18:50, então criei uma branch chamada fix-ssl-swapi que contem uma correção para que a aplicação não tente validar esse certificado ssl vencido.
