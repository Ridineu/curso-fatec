-- PARTE 4

-- 1

SELECT C.COD_CLIENTE AS CODIGO_CLIENTE , C.NOME_CLIENTE, S.COD_SOLICITACAO AS CODIGO_DAS_SOLICITACOES
FROM CLIENTE C ,SOLICITACAO S
WHERE S.DATA_SOLICITACAO BETWEEN '01/10/2016' AND '22/06/2017' AND C.COD_CLIENTE = S.COD_CLIENTE;

-- 2

SELECT Nome_produto 
FROM Produto p, Solicitacao s, Requisicao r
WHERE p.Cod_produto = s.Cod_produto AND s.Cod_solicitacao = r.Cod_solicitacao AND Situacao_requisicao = 'Atendida'
GROUP BY p.Nome_produto
HAVING COUNT(*) = (SELECT MAX(COUNT(*))
					FROM Solicitacao s, Requisicao r
					WHERE s.Cod_solicitacao = r.Cod_solicitacao AND Situacao_requisicao = 'Atendida'
					GROUP BY Cod_produto);

-- 3

SELECT COUNT(s.Cod_solicitacao) as NUM_SOLICITAC, p.TIPO_PRODUTO 
FROM Produto p, Solicitacao s
WHERE p.Cod_produto = s.Cod_produto
GROUP BY p.TIPO_PRODUTO;
					
-- 4

CREATE OR REPLACE VIEW custoManutencao_cliente
AS
	SELECT Nome_cliente, SUM(Custo_total)
	FROM  Cliente c, Solicitacao s, Requisicao r
	WHERE c.Cod_cliente = s.cod_cliente AND 
		  s.cod_solicitacao = r.cod_solicitacao AND
		  situacao_requisicao = 'Atendida' 
    GROUP BY Nome_cliente;
					
-- Não, pois a view utiliza o operador SUM, tornando impossivel a atualização.					
					
-- 5

SELECT o.Cod_ocorrencia, o.Cod_solicitacao, o.Data_ocorrencia, o.Descricao_ocorrencia, o.Horas_gastas
FROM Ocorrencia o, Solicitacao s, Requisicao r
WHERE o.Cod_solicitacao = s.Cod_solicitacao AND s.Cod_solicitacao = r.Cod_solicitacao AND Situacao_requisicao = 'Não atendida';

-- 6

SELECT TRAB_CATEGORIAPROBLEMA.NOME_CATEGORIA 
FROM
	(SELECT COUNT(TRAB_SOLICITACAO.COD_SOLICITACAO) NUMERO,TRAB_SOLICITACAO.COD_CATEGORIA
	 FROM TRAB_SOLICITACAO
	 WHERE DATA_SOLICITACAO  BETWEEN '21/04/2017' AND '21/06/2017'
	 GROUP BY TRAB_SOLICITACAO.COD_CATEGORIA
	 HAVING COUNT(TRAB_SOLICITACAO.COD_SOLICITACAO) = (
		SELECT MAX(COUNT(TRAB_SOLICITACAO.COD_SOLICITACAO)) NUMERO
		FROM TRAB_SOLICITACAO
		WHERE DATA_SOLICITACAO  BETWEEN '21/04/2017' AND '21/06/2017'
		GROUP BY TRAB_SOLICITACAO.COD_CATEGORIA)
    )SUB,TRAB_CATEGORIAPROBLEMA
WHERE SUB.COD_CATEGORIA = TRAB_CATEGORIAPROBLEMA.COD_CATEGORIA

-- 7

-- Necessário acessar os códigos do produtos não contidos na tabela solicitação, por isso do sub select.


Select Cod_Produto
FROM Produto 
WHERE cod_Produto not in (SELECT cod_Produto from  Solicitacao);

-- 8

SELECT t.Nome_tecnico
FROM Tecnico t, Solicitacao s, Requisicao r, Ocorrencia o
WHERE t.Cod_tecnico = s.Cod_tecnico AND s.Cod_solicitacao = o.Cod_solicitacao AND s.Cod_solicitacao = r.Cod_solicitacao AND Situacao_requisicao = 'Aguardando peças'
GROUP BY t.Nome_tecnico
HAVING COUNT(o.Cod_solicitacao) > 2;

-- 9

ALTER TABLE Tecnico
  ADD data_inclusao DATE;
  
UPDATE Tecnico
SET data_inclusao = SYSDATE;

-- 10

-- Serve para agrupar os dados, facilitanto o conjunto. Um ou mais tabelas pode ser agrupadas seguindo um criterio como "Horas_Gastas_Totais"

SELECT S.COD_CATEGORIA, SUM (HORAS_GASTAS_TOTAIS) AS TOTAL_HORAS_POR_CATEGORIA
FROM SOLICITACAO S
GROUP BY S.COD_CATEGORIA;

SELECT COUNT(SOLICITACAO.COD_SOLICITACAO) NUMERO,SOLICITACAO.COD_CATEGORIA
FROM SOLICITACAO
WHERE DATA_SOLICITACAO  BETWEEN '21/04/2017' AND '21/06/2017'
GROUP BY SOLICITACAO.COD_CATEGORIA;

-- 11

-- A Cláusula HAVING é utilizada para selecionar linhas de uma seleção feita com GROUP BY ( restrição para o GROUP BY).
-- Listando o nome do cliente e sua cidade só das cidades que possuam um ou mais cliente.

SELECT Nome_cliente, Cidade_cliente
FROM Cliente
WHERE Cidade_cliente IN (SELECT Cidade_cliente
						FROM Cliente
						GROUP BY Cidade_cliente
						HAVING COUNT(Cidade_cliente) > 1);

-- 12

-- Esta seleção retorna o produto com a quantidade de solicitações menor ou igual ao produto 'Excel'

SELECT Nome_produto, COUNT(Produto.COD_PRODUTO) 
FROM Produto INNER JOIN SOLICITACAO ON Solicitacao.cod_produto = produto.cod_produto
GROUP BY Nome_produto 
HAVING COUNT(Produto.COD_PRODUTO) <= 
(SELECT COUNT(Produto.COD_PRODUTO) FROM PRODUTO INNER JOIN Solicitacao 
ON solicitacao.cod_produto = produto.cod_produto
WHERE Produto.NOME_PRODUTO = 'Excel');
						
-- 13

SELECT Descricao_Produto 
FROM TBProduto 
WHERE Cod_Produto IN (SELECT Cod_Produto FROM TBProduto WHERE Fabricante_Produto = 'Microsoft');

						
-- 14

-- Com o subselect temos o codigo do cliente que possua duas ou mais solicitações.

SELECT Nome_cliente
FROM Cliente
WHERE Cod_cliente NOT IN (SELECT Cod_cliente
						  FROM Solicitacao
						  GROUP BY Cod_cliente
						  HAVING COUNT(*) > 1);

-- 15

SELECT *
FROM TRAB_PRODUTO
WHERE EXISTS (SELECT COD_PRODUTO FROM TRAB_SOLICITACAO);						  
						  
-- 16

-- Exibe todas as informacoes dos produtos que não possuem solicitacoes      
                     
SELECT * FROM PRODUTO
WHERE Cod_produto NOT EXISTS (SELECT Cod_Produto FROM Solicitacao 
							  WHERE Solicitacao.COD_PRODUTO = PRODUTO.COD_PRODUTO);

-- 17

-- Este comando permite alterar o valor do custo hora, aumentado-o em 10%, nas categoria que foram utilizadas em solicitações no mês de março de 2017

UPDATE CategoriaProblema
SET Custo_hora = Custo_hora * 1.1;
WHERE Cod_categoria IN (SELECT s.Cod_categoria
						  FROM CategoriaProblema c, Solicitacao s
						  WHERE c.Cod_categoria = s.Cod_categoria AND Data_solicitacao >= '01/03/2017' AND Data_solicitacao <= '31/03/2017');

-- 18

DELETE FROM Ocorrencia WHERE Data_Ocorrencia 
IN (SELECT Data_Ocorrencia FROM Ocorrencia WHERE Horas_Gastas = 3);						  
						  
-- PARTE 5

-- 1

-- Com está função, é possível consultar a quantidade de solicitação de um
-- produto a partir de seu código.

CREATE OR REPLACE FUNCTION Consulta_solicitacao_prod(pcod_prod number)
return number
as
	vqnt number;
begin
	select COUNT(Cod_produto) into vqnt
	from Solicitacao
	where Cod_produto = pcod_prod;
	
	return vqnt;
end;

begin
	dbms_output.put_line(Consulta_solicitacao_prod(1));
end;

-- 2

CREATE TABLE TABLOG 
( Mensagem varchar(100)); 

CREATE OR REPLACE TRIGGER I_ocorrencia 
AFTER INSERT ON Ocorrencia 
FOR EACH ROW 
DECLARE Qtde NUMBER(5); 
BEGIN 
	SELECT COUNT(Cod_solicitacao) INTO Qtde 
	FROM Ocorrencia where COD_solicitacao = :NEW.Cod_solicitacao; 
	IF Qtde >= 5 THEN 
		INSERT INTO TABLOG VALUES('Situação Grave – grande numero de ocorrências' || ocorrencia.cod_solicitacao ||' ' || Qtde); 
	END IF; 
END;


-- 3

CREATE OR REPLACE TRIGGER Excluir_solicitacao
BEFORE DELETE ON Solicitacao
FOR EACH ROW

BEGIN
	DELETE FROM Ocorrencia
	WHERE Cod_solicitacao = :old.cod_solicitacao;
END;

-- 4

CREATE OR REPLACE PROCEDURE Calc_Custo_Manutencao (Cod_solicitacao_P NUMBER)
AS
	Hora_Ocor Ocorrencia.Horas_gastas % type;
	Tipo_prod Produto.Tipo_produto % type;
	
	BEGIN
		SELECT SUM(Horas_gastas) INTO Hora_Ocor
		FROM Ocorrencia
		WHERE Cod_solicitacao = Cod_solicitacao_P;
		
		SELECT Tipo_produto INTO Tipo_prod
		FROM Produto p, Solicitacao s
		WHERE p.Cod_produto = s.Cod_produto AND S.Cod_solicitacao = Cod_solicitacao_P;
		
		IF Tipo_prod = 'HW' THEN
			UPDATE Solicitacao
			SET Custo_total = Hora_Ocor * 20.00
			WHERE Cod_solicitacao = Cod_solicitacao_P;
		ELSE
			UPDATE Solicitacao
			SET Custo_total = Hora_Ocor * 30.00
			WHERE Cod_solicitacao = Cod_solicitacao_P;
		END IF;
		
		EXCEPTION
			WHEN NO_DATA_FOUND THEN
				RAISE_APPLICATION_ERROR(-20001, 'Solicitacao não existe');
	END;

BEGIN
	Calc_Custo_Manutencao(4);
END;

-- 5

CREATE OR REPLACE 
PROCEDURE CLASSIFICA_PROD
AS
CODIGO_PROD INTEGER;
NOME_PROD VARCHAR2(30);
CLASS_PROD VARCHAR2(500);
CONT INTEGER;
TOTAL INTEGER;
TOTAL_REQ INTEGER;

CURSOR CUR_ATU
IS
SELECT COD_PRODUTO, NOME_PRODUTO FROM PRODUTO;

BEGIN

  SELECT COUNT(COD_PRODUTO) INTO TOTAL 
  FROM PRODUTO;

	OPEN CUR_ATU;
	CONT := 0;

	LOOP
		
    FETCH CUR_ATU INTO CODIGO_PROD, NOME_PROD;
    
		SELECT COUNT(COD_REQUISICAO) INTO TOTAL_REQ 
		FROM REQUISICAO INNER JOIN SOLICITACAO ON REQUISICAO.COD_SOLICITACAO = SOLICITACAO.COD_SOLICITACAO 
		WHERE SOLICITACAO.COD_PRODUTO = CODIGO_PROD;

		IF TOTAL_REQ >= 15 THEN
			CLASS_PROD := 'Produto Ruim – não recomendar';
		ELSIF TOTAL_REQ >= 5 AND TOTAL_REQ < 15 THEN
			CLASS_PROD := 'Produto a ser verificado';
		ELSIF TOTAL_REQ > 0 AND TOTAL_REQ < 5 THEN
			CLASS_PROD := 'Produto Bom';
		ELSE
			CLASS_PROD := 'Produto Excelente – recomendar';
		END IF;

		UPDATE MENSAGEM 
		SET CLASSIFICACAO = CLASS_PROD,
				NOME_PRODUTO = NOME_PROD
		WHERE COD_PRODUTO = CODIGO_PROD;

		IF SQL%ROWCOUNT = 0 THEN
			INSERT INTO MENSAGEM VALUES (CODIGO_PROD, NOME_PROD, CLASS_PROD);
		END IF;
    
    CONT := CONT+1;
		
		EXIT WHEN CONT = TOTAL;
    
	END LOOP;

END CLASSIFICA_PROD;