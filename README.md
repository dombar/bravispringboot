# Exigências
Java - 1.8.x
Maven - 3.x.x

# Etapas para o build

1 - Clone o projeto

 git clone https://github.com/dombar/bravispringboot.git

2 - Crie e execute o aplicativo usando o maven

 cd bravispringboot
 mvn package
 java -jar target/bravi-0.0.1-SNAPSHOT.jar
 
3 - Execute o aplicativo pelo Docker

 cd bravispringboot
 mvn package
 docker-compose -f docker-compose.yml up -d --build
 
# Balanced Brackets

Exemplo de requisição REST:

POST - http://localhost:8080/balanced/
Content-Type : application/json
Body : {
  "text":"[]"
}

# Contact List

Exemplo de requisição REST:

1 - Listar todo os contatos:

GET - http://localhost:8080/person/all

2 - Listar apenas um contato:

GET - http://localhost:8080/person/{id}

3 - Salvar um contato

POST - http://localhost:8080/person/
Content-Type : application/json
Body :{
  "name":"xxxx",
  "email":["xxxx@xx.xx"],
  "phone":["999999999"],
  "whatapp":["999999999"]
}

4 - Editar um contato

PUT - http://localhost:8080/person/{id}
Content-Type : application/json
Body :{
  "name":"xxxx",
  "email":["xxxx@xx.xx"],
  "phone":["999999999"],
  "whatapp":["999999999"]
}

5 - Deletar um contato

DELETE - http://localhost:8080/person/{id}
