Para criação de usuarios na api acessar basta acessar a rota "/api/user", passando os seguinte valores no POST:
{
    "username": "seu user name",
    "password": "sua senha",
    "role": "USER"
}
Isto feito, para geração do token JWT acessar rota "/login" passando os seguinte valores no POST:
{
"username": "seu user name",
"password": "sua senha"
}
E com isso você tera o seu token JWT para utilização em todas as rotas.

Já na parte do docker, necessario ir no arquivo POM.XML, e alterar o repository da imagem docker presente na linha 111, passando o seu 
respositorio no docker hub. 
Com isso é necessario dar o comando -> mvn package
dado esse comando com sucesso, agora precisamos confirurar o nosso arquivo de configuração do M2, para isso
acesse o arquivo chamado settings.xml presente dentro da pasta ".m2" da sua maquina
com isso abra o arquivo e adicione as seguintes tags dentro da tag server:
<server> -->> tag já existente no arquivo setings xml
    <id>docker.io</id>
    <username>{docker_id}</username>
    <password>{senha_docker_hub}</password>
    <configuration>
        <email>{email}</email>
    </configuration>
</server>

Apos configurado o seu server no setings xml, usar o comando -> mvn dockerfile:push
E pronto temos nosso jwt token e Docker configurado.

link exemplo implementação JWT:
https://javatodev.com/spring-boot-jwt-authentication/

link exemplo implementação docker:
https://medium.com/@fernandoevangelista_28291/criando-e-enviando-imagem-docker-com-java-e-maven-4fa3c70dba0f

