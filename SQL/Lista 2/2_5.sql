-- 1

CREATE OR REPLACE VIEW Cli_Prazo
AS
	SELECT Num_Pedido, Cod_Cliente, Prazo_Entrega
	FROM Pedido;

-- 2

CREATE OR REPLACE VIEW Prod_Kg
AS
	SELECT *
	FROM Produto
	WHERE Unidade = 'KG';
	
-- 3

CREATE OR REPLACE VIEW Prod_ValMenorMedia
AS 
	SELECT *
	FROM Produto
	WHERE Valor_Unitario < (SELECT AVG(Valor_Unitario) FROM Produto);
	
-- 4

CREATE OR REPLACE VIEW Vendedor_Pedido
AS
	SELECT V.Cod_Vendedor Cod_Vendedor, Nomevendedor Nome, COUNT(P.Cod_Vendedor) Quantidade_Pedido
	FROM Vendedor V, Pedido P
	WHERE V.Cod_Vendedor = P.Cod_Vendedor
	GROUP BY V.Cod_Vendedor, Nomevendedor;
	
-- 5

 /* Apenas a primeira e segunda view é atualizavel */ 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	