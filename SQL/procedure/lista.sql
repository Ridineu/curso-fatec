-- 2

CREATE OR REPLACE PROCEDURE Calc_PercComissao(PCOD NUMBER)
AS 
	vsoma item_pedido.pco_unit%TYPE;
	vperc vendedor.faixa_comissao%type;
BEGIN	
	SELECT SUM(quantidade * pco_unit) into vsoma
	from item_pedido ip 
	where ip.num_pedido in (select num_pedido 
						   from pedido
						   where cod_vendedor = PCOD);
	vperc := 0;
	if vsoma > 0 and vsoma < 100 THEN
		vperc := 10;
	else
		if vsoma >= 100 and vsoma <= 1000 then
			vperc := 15;
		else
			if vsoma > 1000 then
				vperc := 20;
			end if;
		end if;	
	END IF;
	
	update vendedor 
	set faixa_comissao = vperc
	where cod_vendedor = pcod;
	
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		INSERT INTO TAB_ERRO 
		VALUES(SYSDATE,'vendedor não existente');
END;

-- 3

CREATE OR REPLACE PROCEDURE execTres(pcod number)
as
	vpedido item_pedido.cod_produto%type;
begin
	select count(cod_produto) into vpedido
	from item_pedido
	where cod_produto = pcod;
	
	if vpedido = 0 then
		--insert into tabLog(sysdate, pcod, descricao, 1)
		--select descricao from produto where cod_produto = pcod;
		delete from produto where cod_produto = pcod;	
	end if;
	commit;
EXCEPTION
	when NO_DATA_FOUND then
		insert into tab_erro 
		values (sysdate, 'Código do produto inexistente');
end;


-- 4 

create or replace procedure execQuatro(pcodProd number, pcodCli number, pcodVend number)
as
	aux number;
	vprazo pedido.prazo_entrega%type;
begin
	-- ver se existe esse código na tabela produto
	select cod_produto into aux; 
	from produto
	where cod_produto = pcod;
	
	vprazo:=sysdate;
	
	if pcod > 0 and pcod < 21 then
		vprazo:= vprazo + 15;
	else
		if pcod > 10 and pcod < 31 then
			vprazo:= vprazo + 30;
		end if;
	end if;
	
	insert into pedido 
		values(61, vprazo, pcodCli, pcodVend);
	
	commit;
	
exception
	when NO_DATA_FOUND THEN
		insert into tab_erro 
		values (sysdate, 'Código do produto inválido');
end;