-- 3

ALTER TABLE Cliente MODIFY(Endereco varchar2(30));

-- 4

ALTER TABLE Item_Pedido ADD(Pco_Unit number(6,2));

-- 5

UPDATE Cliente 
SET Cep = '18035-400' 
WHERE Cidade = 'Sorocaba'

-- 6 

Update Pedido
SET Prazo_Entrega = Prazo_Entrega + 10
Where Cod_Cliente = 20;

-- 7 

Update Produto
SET valor_unitario = valor_unitario * 0,1 + valor_unitario
WHERE unidade = 'KG'

-- 8 

DELETE From Produto
where unidade = 'CX' AND valor_unitario > 50 