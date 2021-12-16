# language: pt
Funcionalidade: Gerenciamento de um animal da loja

  Cenario: Lista somente animais disponiveis para a venda
    Dado que eu possua animais available
    Quando eu pesquiso por todos os animais available
    Entao eu recebo a lista de animais available
    # passo desnecessario, somente para exemplo
    E eu recebo uma lista de animais available

  Cenario: Lista somente animais pending
    Dado que eu possua animais pending
    Quando eu pesquiso por todos os animais pending
    Entao eu recebo a lista com 2 animais

  Cenario: Lista somente animais sold
    Dado que eu possua animais sold
    Quando eu pesquiso por todos os animais sold
    Entao eu recebo a lista com 1 animais

  Cenario: Nao lista nenhum animal sold
    Dado que eu nao possua animais sold
    Quando eu pesquiso por todos os animais sold
    Entao eu recebo a lista com 0 animal

  Esquema do Cenario: Lista animais pelo seu estado de venda
    Dado que eu possua animais <estado>
    Quando eu pesquiso por todos os animais <estado>
    Entao eu recebo a lista com <quantidade> animais

    Exemplos: Animais em estoque
      | estado    | quantidade  |
      | available | 7           |
      | pending   | 2           |
      | sold      | 0           |
