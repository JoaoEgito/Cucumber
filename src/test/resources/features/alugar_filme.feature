@unit
Feature: Alugar Filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlarpreços e datas de entrega

Scenario: Devo alugar um filme com sucesso
 		Given um filme 
 			| estoque |   2   |
 			|  preco  |   3   | 
 			|   tipo  | comum |
 		
	 	When alugar
	 	Then o preço do aluguel será R$ 3
	 	And a data de entrega será em 1 dia
	 	And o estoque do filme será de 1 unidade
 	
Scenario: Não deve alugar filme sem estoque
 		Given um filme com estoque de 0 unidades
 		When alugar
 		Then não será possível por falta de estoque
 		And o estoque do filme será de 0 unidade
 		
Scenario Outline: Deve dar condições conforme tipo de aluguel
		Given um filme com estoque de 2 unidades
 		And o preço do aluguel seja R$ <preco>
 		And o tipo de aluguel é <tipo>
 		When alugar
 		Then o preço do aluguel será R$ <valor>
 		And a data de entrega será em <qtdDias> dias
 		And a pontuação será de <pontuacao> pontos
 		
Examples: 
 		| preco |   tipo    | valor | qtdDias | pontuacao |
 		|   4   | extendido |   8   |    3    |     2     |
 		|   4   |   comum   |   4   |    1    |     1     |
 		|  10   | extendido |  20   |    3    |     2     |
 		|   5   |  semanal  |  15   |    7    |     3     |
 		
#Scenario: Deve dar condições especiais para categoria extendida
 #		Given um filme com estoque de 2 unidades
 #		And o preço do aluguel seja R$ 4
 #		And o tipo de aluguel é extendido
 #		When alugar
 #		Then o preço do aluguel será R$ 8
 #		And a data de entrega será em 3 dias
 #		And a pontuação será de 2 pontos
 #		
#Scenario: Deve alugar para categoria comum
 #		Given um filme com estoque de 2 unidades
 #		And o preço do aluguel seja R$ 4
 #		And o tipo de aluguel é comum
 #		When alugar
 #		Then o preço do aluguel será R$ 4
 #		And a data de entrega será em 1 dia
 #		And a pontuação será de 1 pontos
 		

	
