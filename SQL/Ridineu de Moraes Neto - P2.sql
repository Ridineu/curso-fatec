-- 1

CREATE OR REPLACE PROCEDURE Proc_AtualizaPrecoLivro(PCod_Autor AUTORLIVRO.CODAUTOR%TYPE)
AS
BEGIN
  UPDATE LIVROS 
  SET Preco = Preco * 1.05
  WHERE codlivro in (SELECT CODLIVRO
                     FROM AUTORLIVRO 
                     WHERE codautor = PCod_Autor) 
        AND dataedicao < '01/01/2010';     
  COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		INSERT INTO TabMsg2
		VALUES(SYSDATE,'Código de autor inexistente');  
END;

EXEC Proc_AtualizaPrecoLivro(1);

-- 2

CREATE OR REPLACE FUNCTION Func_QtdLivrosAssunto(PCod_Assunto LIVROS.CODLIVRO%TYPE)
RETURN varchar2
AS
	retorno varchar2(150);
	qtd number;
BEGIN
	SELECT COUNT(CodLivro) INTO qtd
	FROM Livros
	WHERE CodAssunto = PCod_Assunto;

	IF qtd < 3 THEN
		retorno := 'É necessário adquirir no mínimo mais três exemplares de livros pertencentes ao assunto ' || PCod_Assunto;
	ELSE
		retorno := 'Quantidade superior de livros desse assunto superior a três.';
	END IF;
	RETURN retorno;
END;

BEGIN 
	dbms_output.put_line(Func_QtdLivrosAssunto(1));
END;