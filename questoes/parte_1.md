# 1) Entendendo como disparar o backend

  - a. Para disparar o backend da aplicação de controle de corridas, abra uma janela de “shell” na raiz do projeto (pasta que contém o arquivo “.pom”) e digite “mvn   spring-boot:run”.

  - b. Observe que após a compilação o Spring irá disparar uma instancia do Apache Tom Cat (um servidor WEB) e colocar o backend para executar lá. O acesso a aplicação será feito através da porta 8080 (localhost:8080).

# 2) Entendendo como operar o sistema a partir do Software “Postman”

  - a. Inicialmente analise o código da aplicação de maneira a identificar os “endpoints” do sistema.

  - b. Utilize o PostMan ou outro software equivalente para enviar as requisições HTTP e obter as respostas. Por exemplo envie a seguinte requisição “GET”:
    GET localhost:8080/ctrlCorridas/corredor

    A resposta deve ser um JSON:

    [ { "cpf": "10001287", "nome": "Luiz", "diaDn": 22, "mesDn": 5, "anoDn": 1987, "genero": "masculino" } ]

  - c. Teste com diferentes requisições GET e POST

# 3) Altere o programa de maneira a deixar algumas corridas pré-cadastrados. Isso irá facilitar os próximos passos considerando que estamos usando o H2Db que é um banco de dados em memória. Isso significa que toda a vez que paramos o servidor os dados do banco são todos perdidos.

# 4) Identifique em que pontos foi usado o padrão de injeção de dependência. O Spring Boot trabalha com o princípio da inversão de controle? Explique.

# 5) Aplique o padrão “Repository” de maneira a isolar o acesso aos dados.

# 6) O uso do padrão “Repository” levou a necessidade de uso do padrão de injeção de dependência? Justifique sua resposta.
  Sim, pois agora o controller recebe os repositories por injeção de dependência, que por sua vez recebem o jdbc por injeção de dependência