#language:pt

Funcionalidade: Gerenciamento de um usu�rio na Petstore
  Algum contexto do neg�cio
  Hist�ria do Jira
  Qualquer coisa que fa�a sentido pro neg�cio

  @teste1
  Cenario: Cria um usuario na loja
    Quando faco um POST para v3/user com os seguintes valores:
      | id         | 11                      |
      | username   | renato                  |
      | firstName  | Renato                  |
      | lastName   | Silva                   |
      | email      | rsilva_tst123@gmail.com |
      | password   | 12345                   |
      | phone      | 947528574               |
      | userStatus | 1                       |
    Entao faco um GET para v3/user/renato, o usuario criado eh retornado

  @deleteAllUsers
  Cenario: Cria usuario na loja refletindo o negocio
    Quando crio um usuario
    Entao o usuario e criado com sucesso
