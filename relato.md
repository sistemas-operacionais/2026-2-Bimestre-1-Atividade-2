
# ​Relatório de implementação de linha de execução em Clojure.
## ​Introdução:
​Este relato faz parte do processo avaliativo da disciplina de Sistemas Operacionais no curso superior em Análise e Desenvolvimento de Sistemas, ofertado na Diretoria Acadêmica de Gestão e Tecnologia da Informação (DIATINF) no campus Natal-Central do Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Norte (IFRN).

​Tem como objetivo principal relatar como implementar linhas de execução na linguagem Clojure, demonstrando o uso de chamadas nativas de threads da JVM (Thread.), sincronização de ciclos de vida (.start e .join) e abstrações concorrentes de alto nível (future). 
​O grupo de trabalho foi formado por: Geovanna Negreiros, Haama Kethelen e Lucas Natan.

​Implementando múltiplas linhas de execução em Clojure. 
​Informações gerais sobre Clojure:

## ​Objetivo: 
Criada por **Rich Hickey** em 2007, Clojure foi concebida para simplificar a programação concorrente e paralela em processadores modernos 'multicore'. Seu foco é eliminar as falhas típicas de sincronização manual, como travas (locks), condições de corrida (race conditions) e bloqueios mútuos (deadlocks), promovendo o isolamento de estados mutáveis e o uso universal de coleções e valores estritamente imutáveis.

## ​Paradigma:
Funcional, baseada na família **Lisp** (homoiconicidade — código representado como estruturas de dados), com suporte a metaprogramação via macros e foco em funções de primeira classe e avaliação pura.
​Disponibilidade e Plataforma: É executada primariamente sobre a Máquina Virtual Java (JVM), o que garante compatibilidade total com o ecossistema Java, permitindo empacotamento em arquivos .jar e execução multiplataforma (Linux, Windows, macOS). Possui também implementações para JavaScript/Navegadores (ClojureScript) e .NET (Clojure CLR). Seu compilador, CLI e ferramentas de automação (como Leiningen) estão disponíveis no site oficial clojure.org.

## ​Criando linhas de execução:
​Como Clojure opera sobre a JVM, as linhas de execução podem ser criadas diretamente por interoperabilidade com as classes padrão do Java (java.lang.Thread). Cada instância de Thread. mapeia diretamente uma linha de execução (kernel thread) gerenciada pelo escalonador do Sistema Operacional hospedeiro.
​Para criar uma thread básica, instancia-se Thread. passando uma função anônima (fn [] ...) que implementa a interface Runnable. A execução só é escalonada a partir do momento em que o método .start é invocado.
