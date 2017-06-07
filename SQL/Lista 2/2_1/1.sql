CREATE TABLE Cliente(
	Cod_cliente number(5,0) PRIMARY KEY,
	Nome_cliente varchar2(30),
	Endereco varchar2(25),
	Cidade varchar2(20),
	Cep varchar2(10),
	UF varchar2(2) ) ;

CREATE TABLE Vendedor(
	Cod_vendedor number(5,0) PRIMARY KEY,
	nomevendedor varchar2(30),
	faixa_comissao number(4,2),
	salario_fixo number(7,2) );

CREATE TABLE Produto(
	Cod_produto number(3, 0) PRIMARY KEY,
	Descricao varchar2(20),
	unidade varchar2(2),
	valor_unitario number(8,2) );
	
CREATE TABLE Pedido(
	Num_pedido number(5,0) PRIMARY KEY,
	Prazo_entrega date,
	Cod_cliente number(5,0) REFERENCES Cliente,
	Cod_vendedor number(5,0) REFERENCES Vendedor );
	
CREATE TABLE Item_Pedido(
	Num_pedido number(5,0) REFERENCES Pedido,
	Cod_produto number(5,0) REFERENCES Produto,
	Quantidade number(5,0) );
	
create table tabLog(
	dataOcorrencia date,
	cod_produto number(5,0),
	descricao varchar2(20),
	id_user number(5,0) );
	
-- Exercicio para POO	
	
create table TBDEPARTAMENTO(
	SIGLA_DEP varchar2(2),
	NOME_DEP varchar2(30) );
)

-- Utilizando Trigger


	
	
	
	
	