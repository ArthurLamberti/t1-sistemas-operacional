# 1) Implemente uma nova funcionalidade (defina um “endpoint” correspondente) que permita consultar as seguintes estatísticas: média, mediana e desvio padrão do tempo em minutos que o corredor tem levado para concluir provas de uma determinada distancia que é informada por parâmetro em uma requisição “GET”. O “endPoint” deve retornar à quantidade de provas consideradas juntamente com as três estatísticas. A estrutura do método que trata tal “endpoint” fica como segue:
  - estrutura
    @GetMapping("/estatisticas") 
    @CrossOrigin(origins = "*") 
    public EstatísticasDTO estatisticas(@RequestParam final int distancia){ 
      ... 
    }

# 2) Explique por que foi necessário o uso do padrão DTO para a solução da questão 1.
  Foi necessário o uso do padrao DTO devido ao endpoint retornar campos calculados que nem estao sendo salvos no banco de dados.
# 3) Implemente uma nova funcionalidade (defina um “endpoint” correspondente) que permita identificar, dentre as provas da distância indicada ocorridas em um determinado ano (informado pelo usuário), em que momento foi obtido o melhor ganho de performance em relação a prova anterior. Para tanto compare os resultados das provas do ano duas a duas na ordem cronológica e identifique o par onde ocorreu a maior redução no tempo (melhoria de performance). Retorne o nome das duas provas. A estrutura do método que trata tal “endpoint” fica como segue:
  - estrutura
    @GetMapping("/aumentoPerformance") 
    @CrossOrigin(origins = "*") 
    public PerformanceDTO aumentoPerformance(@RequestParam final int distancia, @RequestParam final int ano){
      ... 
    } 