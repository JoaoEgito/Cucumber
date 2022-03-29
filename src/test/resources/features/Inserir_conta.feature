
@tag
Feature: Cadastro de contas
	Como um usuário
	Gostaria de cadastrar contas
	Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#	Background:
#		Given que estou acessando a aplicação
    #When informo o usuário "a1@a1.com"
    #And a senha "12345"
    #And seleciono entrar
    #Then visualizo a página inicial
    #When seleciono Contas
    #And seleciono Adicionar
    #
#	Scenario Outline: Deve validar regras cadastro contas
#		When informo a conta "<conta>"
#		And seleciono Salvar
#		Then recebo a mensagem "<mensagem>"
#	
#	Examples:	
#		|      conta     |               mensagem             |
#		| Conta de Teste |    Conta adicionada com sucesso!   |
#		|                |       Informe o nome da conta      |
#		| Conta de Teste | Já existe uma conta com esse nome! |
#	    


	Background:
		Given que desejo adicionar uma conta
    
    
	Scenario Outline: Deve validar regras cadastro contas
		When informo a conta "<conta>"
		Then recebo a mensagem "<mensagem>"
	
	Examples:	
		|      conta     |               mensagem             |
		| Conta de Teste |    Conta adicionada com sucesso!   |
		|                |       Informe o nome da conta      |
		| Conta de Teste | Já existe uma conta com esse nome! |
	    
    