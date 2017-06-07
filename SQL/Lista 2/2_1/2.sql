-- Tabela Cliente

INSERT INTO Cliente 
VALUES (1, 'João Pedro', 'Rua São João', 'Votorantim', '18111-120', 'SP')

INSERT INTO Cliente 
VALUES (2, 'Caio da Silva', 'Avn. Bandeira', 'São Paulo', '19123-135', 'SP')

INSERT INTO Cliente 
VALUES (3, 'Jucimar Amaralto', 'Rua 31 de março', 'Votorantim', '18105-102', 'SP')

INSERT INTO Cliente 
VALUES (4, 'Henrique Moraes', 'Avn. Eng. Miguel Ramos', 'Piedade', '15452-105', 'SP')

INSERT INTO Cliente 
VALUES (5, 'Leonardo Amaral', 'Rua Osmar José', 'Sorocaba', '18077-460', 'SP')

INSERT INTO Cliente
VALUES(20, 'Ridineu Moraes', 'Rua Julio', 'Votorantim', '18110-135', 'SP')

-- Tabela Vendedor

INSERT INTO Vendedor 
VALUES (1, 'Rafael Pedro', 5, 1800.5)

INSERT INTO Vendedor 
VALUES (2, 'Samuel Antonio', 7.5, 1500.00)

INSERT INTO Vendedor 
VALUES (3, 'Caio Eduardo', 12.5, 800.5)

INSERT INTO Vendedor 
VALUES (4, 'Maria Angelica', 9, 2000.00)

INSERT INTO Vendedor 
VALUES (5, 'Beatriz Arantes', 15, 1800.5)

INSERT INTO Vendedor
VALUES (6, 'José Pedro', 8.5, 800)

INSERT INTO Vendedor
VALUES (7, 'José Mané', 7, 6000)

-- Tabela Produto

INSERT INTO Produto
VALUES (1, 'Mouse USB', 'un', 30.00)

INSERT INTO Produto
VALUES (2, 'Bola de basquete', 'un', 80.00)

INSERT INTO Produto
VALUES (3, 'Monitor Positivo', 'un', 150.00)

INSERT INTO Produto
VALUES (4, 'Apostila SQL', 'un', 25.00)

INSERT INTO Produto
VALUES (5, 'Pen-Drive 8GB', 'un', 36.00)

INSERT INTO Produto
VALUES (6, 'Grafite 0.6 mm', 'un', 3.00)

INSERT INTO Produto
VALUES (7, 'Café grão', 'KG', 10)

INSERT INTO Produto
VALUES (8, 'Bombril', 'CX', 55)

-- Pedido

INSERT INTO Pedido
VALUES(1, '24/05/2017', 1, 3)

INSERT INTO Pedido
VALUES(2, '05/03/2017', 2, 2)

INSERT INTO Pedido
VALUES(3, '05/03/2017', 3, 1)

INSERT INTO Pedido
VALUES(4, '05/03/2017', 4, 4)

INSERT INTO Pedido
VALUES(5, '05/03/2017', 5, 5)

INSERT INTO Pedido
VALUES(6, '01/03/2017', 20, 3)

-- Item_Pedido

INSERT INTO Item_Pedido
VALUES(1, 2, 1)

INSERT INTO Item_Pedido
VALUES(1, 3, 1)

INSERT INTO Item_Pedido
VALUES(2, 1, 3)

INSERT INTO Item_Pedido
VALUES(2, 5, 4)

INSERT INTO Item_Pedido
VALUES(2, 4, 2)

INSERT INTO Item_Pedido
VALUES(3, 1, 1)

INSERT INTO Item_Pedido
VALUES(3, 6, 2)

INSERT INTO Item_Pedido
VALUES(3, 4, 8)

INSERT INTO Item_Pedido
VALUES(4, 3, 1)

INSERT INTO Item_Pedido
VALUES(4, 2, 15)

INSERT INTO Item_Pedido
VALUES(5, 5, 30)

INSERT INTO Item_Pedido
VALUES(6, 2, 3)











