# Relatório de implementação de linha de execução em Lua

## Introdução

Este relato faz parte do processo avaliativo da disciplina de Sistemas Operacionais no curso superior em Análise e Desenvolvimento de Sistemas, ofertado pela Diretoria Acadêmica de Gestão e Tecnologia da Informação no Campus Natal-Central do Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Norte.

Tem como objetivo principal relatar a experiência de implementar linhas de execução na linguagem Lua, utilizando a biblioteca Lanes para possibilitar a criação e execução de múltiplas linhas de execução.

O grupo de trabalho foi formado por Andre Medeiros Silva, Denju Gabriel da Silva Lira e Lucas Gabryel Silva de Holanda.

## Implementando múltiplas linhas de execução em Lua

### Informações gerais sobre Lua

Lua é uma linguagem de programação de alto nível, leve e de propósito geral. Ela possui características de diferentes paradigmas, com destaque para a programação imperativa, procedural e também suporte à programação orientada a objetos por meio de seus recursos.

A linguagem é conhecida por ser simples, pequena e facilmente incorporada a outros programas. Lua é utilizada em diferentes áreas, incluindo desenvolvimento de jogos, aplicações embarcadas, automação e sistemas que necessitam de uma linguagem de script.

Para esta atividade, foi utilizada a versão Lua 5.4 juntamente com a biblioteca Lanes, instalada por meio do LuaRocks dentro de um container Docker.

### Criando linhas de execução

Para criar linhas de execução em Lua, foi utilizada a biblioteca Lanes. Ela permite executar funções em diferentes linhas de execução chamadas de lanes.

Primeiramente, a biblioteca foi carregada e configurada:

```lua
local lanes = require("lanes").configure({
    demote_full_userdata = true
})
```

Depois, foi criada uma função contendo as instruções que seriam executadas pela linha de execução. Em seguida, a função `lanes.gen()` foi utilizada para criar uma função responsável por iniciar uma nova lane.

Por fim, a linha de execução foi iniciada e o método `join()` foi utilizado para aguardar sua finalização.

### Passando valores para linhas de execução

Também foi possível passar valores para as linhas de execução. No segundo programa, por exemplo, a função recebeu o nome da pessoa e a quantidade de mensagens que deveriam ser exibidas.

A criação da linha de execução foi feita utilizando:

```lua
local criar_thread = lanes.gen("*", saudar)
```

Depois, os valores foram enviados para a função:

```lua
local thread = criar_thread("Maria", 3)
```

Dessa forma, a lane recebeu o nome "Maria" e o valor 3, realizando três mensagens.

### Múltiplas linhas de execução

No terceiro programa foram criadas cinco linhas de execução para representar trabalhadores realizando uma tarefa.

Foi utilizado um laço de repetição para criar as cinco lanes e os objetos retornados foram armazenados em uma tabela. Depois, outro laço foi utilizado para aguardar a finalização de cada uma delas por meio do método `join()`.

Durante os testes, foi possível observar no terminal as mensagens referentes aos cinco trabalhadores, demonstrando a criação e execução das múltiplas linhas de execução.

A utilização do Docker também foi importante para configurar o ambiente necessário para executar os programas Lua e instalar a biblioteca Lanes por meio do LuaRocks.

## Considerações finais

A implementação dos programas em Lua permitiu compreender melhor o funcionamento de linhas de execução e as diferenças existentes entre linguagens de programação.

Durante a atividade, foi necessário pesquisar e configurar uma biblioteca específica, pois Lua não possui uma API de threads equivalente à utilizada pelo Python nos exemplos fornecidos. A utilização do Lanes permitiu reproduzir a ideia dos programas originais, criando linhas de execução, passando parâmetros e trabalhando com múltiplas execuções.

A experiência também mostrou a importância da configuração do ambiente de execução. O uso do Docker facilitou a instalação do LuaRocks e da biblioteca necessária, permitindo executar os programas de forma padronizada.
