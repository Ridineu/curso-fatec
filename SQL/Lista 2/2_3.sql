-- 1

SELECT *
FROM Item_Pedido
WHERE Quantidade = (SELECT MAX(Quantidade) FROM Item_Pedido);

SELECT MAX(Quantidade)
FROM Item_Pedido;

-- 2

SELECT *
FROM Produto
WHERE Valor_unitario = (SELECT MAX(Valor_unitario) FROM Produto);

SELECT MIN(Valor_unitario)
FROM Produto;

-- 3

SELECT SUM(Salario_Fixo) "Somatória salário"
FROM Vendedor;

-- 4

SELECT COUNT(Cod_Produto) 
FROM Produto
WHERE nidade = 'Lt';

-- 5

SELECT Cidade, COUNT(Cod_Cliente)
FROM Cliente
Group by Cidade;

-- 6

SELECT Cod_Vendedor, COUNT(Cod_Pedido)
FROM Pedido
Group by Cod_Vendedor;

-- 7

SELECT unidade, MAX(valor_unitario), MIN(valor_unitario)
FROM Produto
Group By unidade

-- 8

SELECT CIDADE, COUNT(Cod_Cliente)
FROM Cliente
GROUP BY Cidade
HAVING Count(Cidade) > 4















