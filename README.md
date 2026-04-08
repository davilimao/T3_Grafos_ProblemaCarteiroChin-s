# T3_Grafos_ProblemaCarteiroChin-s
Segue abaixo link do vídeo:
https://drive.google.com/file/d/1sl6XcHJATWisPJw5CesbYrcsGmqALL69/view?usp=sharing

Breve explicacao da eulerizacao realizada

O digrafo original possuia vertices com desequilibrios entre o numero de arestas de entrada e saida, o que impossibilitava a existencia de um circuito euleriano.

Para eulerizar o grafo, foi realizado o seguinte processo:

1. Identificacao dos vertices com desequilibrio

Para cada vertice, foi calculado o valor:

desequilibrio = grau de entrada - grau de saida

Valores positivos indicam falta de arestas de saida.
Valores negativos indicam falta de arestas de entrada.

2. Agrupamento dos vertices em pares compativeis

Os vertices com deficit foram conectados por arestas adicionais que representam os menores caminhos possiveis dentro do grafo.

3. Inclusao de novas arestas

Foram adicionadas quatro novas arestas (representadas pelas cores verde, vermelho, laranja e rosa na imagem).
Essas arestas possuem pesos iguais as menores distancias entre os pares escolhidos e foram usadas para compensar o desequilibrio.

4. Resultado final

Apos a inclusao das novas arestas, todos os vertices ficaram balanceados, ou seja, cada vertice passou a ter o mesmo numero de entradas e saidas.
Assim, o digrafo resultante passou a permitir a existencia de um circuito euleriano.
