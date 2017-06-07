-- 1

SELECT Cod_Vendedor, Nomevendedor
FROM Vendedor, Pedido
WHERE Vendedor.Cod_Vendedor = Pedido.Cod_Vendedor and Cod_Cliente = 10;

-- 2 

SELECT Pedido.Num_Pedido, prazo_entrega, Quantidade, Descricao
FROM Pedido, Item_Pedido, Produto
WHERE Pedido.Num_Pedido = Item_Pedido.Num_Pedido and Item_Pedido.Cod_Produto = Produto.Cod_Produto
and Produto.Cod_Produto = 100;

SELECT Pedido.Num_Pedido, prazo_entrega, Quantidade, Descricao
FROM Pedido, Item_Pedido, Produto
WHERE Pedido.Num_Pedido = Item_Pedido.Num_Pedido and Item_Pedido.Cod_Produto = Produto.Cod_Produto
and Pedido.Num_Pedido = 100;

-- 3

SELECT Vendedor.Cod_Vendedor, Nomevendedor
FROM Vendedor, Pedido, Cliente
WHERE Vendedor.Cod_Vendedor = Pedido.Cod_Vendedor and Pedido.Cod_Cliente = Cliente.Cod_Cliente
and Nome_cliente = 'José da Silva';

-- 4

SELECT Pedido.Num_Pedido, Produto.Cod_Produto, Descricao, Vendedor.Cod_Vendedor, nomevendedor, nome_cliente
FROM Vendedor, pedido, item_pedido, produto, cliente
WHERE Cliente.cod_cliente = Pedido.cod_cliente and Vendedor.cod_vendedor = Pedido.cod_vendedor and
Pedido.num_pedido = Item_Pedido.num_pedido and Produto.cod_produto = Item_Pedido.cod_produto and
Cidade = 'Sorocaba';

-- 5

SELECT Produto.Cod_Produto, Descricao, Quantidade, prazo_entrega
FROM Pedido, Produto, Item_Pedido
WHERE Produto.Cod_Produto = Item_Pedido.Cod_Produto and Item_Pedido.Num_Pedido = Pedido.Num_Pedido
and Pedido.Num_Pedido = 123;

-- 6

SELECT Nome_cliente, endereco
FROM Cliente, Pedido, Vendedor
WHERE (Cidade = 'Sorocaba' OR Cidade = 'Itu') AND Cliente.Cod_Cliente = Pedido.Cod_Cliente
AND Pedido.cod_vendedor = Vendedor.cod_vendedor AND Pedido.Cod_Vendedor = 10; 

























