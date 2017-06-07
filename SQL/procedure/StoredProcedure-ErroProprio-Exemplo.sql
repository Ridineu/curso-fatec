/*

Exemplo) Crie uma stored procedure que receba como parâmetros o cod. do produto e a quantidade
a ser retirada do estoque deste produto. Verificar se o estoque é suficiente ou não p/ realizar
a retirada:

- Se for suficiente: Atualize a tabela produto alterando o estoque do produto em questão.
- Se não for suficiente, trate a exceção.

Verificar também se o produto informado é válido.

Tabela produto -> incluir campo qtdestoq number (5) e inserir valores.

*/

CREATE OR REPLACE Verifica_Estoque(PCOD NUMBER, PQTD_RET NUMBER)
AS 
	E_ESTOQUE EXCEPTION;
	VQTDE PRODUTO.QTDESTOQ%TYPE;
BEGIN	
	SELECT QTDESTOQ INTO VQTDE
	FROM PRODUTO 
	WHERE COD_PRODUTO = PCOD;
	
	IF VQTDE < PQTD_RET THEN
		RAISE E_ESTOQUE;
	ELSE
		UPDATE PRODUTO 
		SET QTDESTOQ = QTDESTOQ - PQTD_RET
		WHERE COD_PRODUTO = PCOD.
	END IF;
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		INSERT INTO TAB_ERRO 
		VALUES(SYSDATE,'PRODUTO NÃO EXISTE');
	WHEN E_ESTOQUE THEN
		ROLLBACK;
		INSERT INTO TAB_ERRO 
		VALUES(SYSDATE, 'ESTOQUE INSUFICIENTE');
END;
	
	
	