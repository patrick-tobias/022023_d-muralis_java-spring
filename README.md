# 022023_d-muralis_java-spring
Criar um projeto Spring Boot para permitir o cadastramento, consulta, exclusão, lista, pesquisa e alteração de Clientes seguindo a modelagem fornecida.
veja o desafio através do arquivo D01_SPRINGBOOT_BASICO_V01_04072022.pdf

**uso do projeto**
O projeto não possui conexão e persistência em banco de dados, em vez disso, foi criada uma classe que simula um banco de dados através de Listas.
Ao iniciar o projeto Spring, o método main instanciará a classe Banco, que contém um método estático de interação pelo terminal e que populará inicialmente o "banco de dados" simulado.

A população inicial dos dados será realizada com dados aleatórios, gerados pela biblioteca JavaFaker

  **url e métodos HTTP**
  O projeto em execução estará habilitado na porta 8080 e aceitará o seguinte caminho
  http://localhost:8080/clientes
  
  Os métodos suportados são
    GET(/clientes), e devolverá todos os clientes cadastrados
    POST(/clientes), e adicionará um novo cliente. É necessário enviar no corpo da requisição o JSON de Cliente.
    PUT(/clientes), e atualizará um cliente. É necessário enviar no corpo da requisição o JSON de Cliente com o id do cliente que se deseja atualizar e seus valores atualizados
    DELETE(/clientes/idCliente), e removerá o cliente com o idCliente enviado
  
  **JSON**
  Estrutura esperada para JSON de Cliente
  {
    "id": 0,
    "nome": "Nome do Usuário",
    "dataCadastro": "01/01/2001",
    "contato": {
        "id": 0,
        "tipo": "email",
        "texto": "email@fatec.sp.gov.br"
    }
  }

**Desafio 2.0 - Faça você também**
Nesse desafio não foi implementado nenhuma lógica de validação de dados.
Embora não tenha sido pedido no desafio, a validação de dados é importante para garantir que os dados estão sendo preenchidos corretamente.

Sugestão: Ao realizar você também o desafio, teste pensar e implementar uma solução que valide os dados manipulados pela aplicação.
