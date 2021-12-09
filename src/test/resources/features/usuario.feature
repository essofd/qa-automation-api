#language:pt

Funcionalidade: Gerenciamento de um usuário na Petstore
  Algum contexto do negócio
  História do Jira
  Qualquer coisa que faça sentido pro negócio

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
