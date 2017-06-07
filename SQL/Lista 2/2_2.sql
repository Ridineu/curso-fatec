-- 1 

SELECT Num_Pedido, Prazo_Entrega
FROM Pedido

-- 2

SELECT Descricao, Valor_Unitario
FROM Produto

-- 3

SELECT Nome_Cliente, Endereco
FROM Cliente

-- 4

SELECT Nomevendedor
FROM Vendedor

-- 5

SELECT * 
FROM Cliente

-- 6 

SELECT * 
FROM Produto

-- 7

SELECT Nomevendedor as nome
FROM Vendedor

-- 8

SELECT Valor_Unitario * 1.1
FROM Produto

-- 9 

SELECT Salario_fixo * 1.05
FROM Vendedor

-- 10 

SELECT Nome_Cliente
FROM Cliente
Where Cidade = 'Sorocaba'

-- 11 

SELECT *
FROM Vendedor
WHERE Salario_fixo < 400

-- 12

SELECT Cod_Produto, Descricao
FROM Produto
WHERE Unidade = 'KG'

-- 13 

SELECT Num_Pedido
FROM Pedido
WHERE prazo_entrega BETWEEN '01/05/2012' AND '01/06/2012'

-- 14 

SELECT Num_Pedido, Prazo_Entrega
FROM Pedido
WHERE prazo_entrega like '%%/%%/2014'
 
-- 15 

SELECT *
FROM Produto
WHERE Valor_Unitario >= 100 AND  Valor_Unitario <= 200

-- 16

SELECT Num_Pedido, Cod_Produto
FROM Item_Pedido
WHERE Quantidade >= 100 AND Quantidade <= 1500

-- 17 

SELECT Nomevendedor
FROM Vendedor
WHERE Nomevendedor like 'José%'

-- 18 

SELECT Nome_Cliente
FROM Cliente
WHERE Nome_Cliente like '%Silva'

-- 19

SELECT Cod_Produto, Descricao
FROM Produto
WHERE Descricao like '%AC%'

-- 20

SELECT Nome_Cliente
FROM Cliente
WHERE Endereco IS NULL

-- 21

SELECT DISTINCT Cidade
FROM CLIENTE

-- 22

SELECT *
FROM CLIENTE
ORDER BY Nome_cliente

-- 23

SELECT *
FROM CLIENTE
ORDER BY Cidade DESC

-- 24

SELECT *
FROM CLIENTE
ORDER BY Cidade, Nome_cliente 

-- 25

SELECT Cod_Produto, Descricao
FROM Produto
WHERE Unidade = 'KG'
ORDER BY Descricao















