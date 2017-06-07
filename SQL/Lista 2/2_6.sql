-- 1

SELECT * 
FROM Cliente
WHERE Cidade = (Select Cidade FROM Cliente WHERE Nome_Cliente = 'João da Silva')


-- 2

SELECT *
FROM Produto
WHERE Valor_Unitario > (SELECT AVG(Valor_Unitario) FROM Produto)

-- 3

SELECT DISTINCT C.Cod_Cliente, Nome_Cliente
FROM Cliente C, Pedido P
WHERE C.Cod_Cliente IN ((SELECT Cod_Cliente FROM P WHERE Cod_Vendedor = 10) 
						 MINUS
					    (SELECT Cod_Cliente FROM P WHERE Cod_Vendedor <> 10));

-- 4

SELECT Cod_Vendedor 
FROM (SELECT COUNT (*) contagem, Cod_Vendedor FROM Pedido GROUP BY Cod_Vendedor)
WHERE contagem < 5;

-- 5

SELECT DISTINCT Vendedor.Cod_Vendedor, Nomevendedor
FROM Pedido, Vendedor
WHERE Vendedor.Cod_Vendedor in ((SELECT Cod_Vendedor FROM Pedido)
								MINUS
							  (SELECT Cod_Vendedor FROM Pedido WHERE Prazo_Entrega LIKE '%%/05/%%'));
							  
-- 6

SELECT Nomevendedor
FROM Vendedor
WHERE Vendedor.Cod_Vendedor = (SELECT Cod_Vendedor FROM Pedido GROUP BY Cod_Vendedor 
      HAVING COUNT (Cod_Vendedor) >= ALL (SELECT COUNT(COd_vendedor) FROM Pedido GROUP BY Cod_Vendedor));

-- 7

SELECT Nome_Cliente, COUNT(P.Cod_Cliente)
FROM Cliente C, Pedido P
WHERE P.Cod_Cliente = C.Cod_Cliente 

	  
	  




















