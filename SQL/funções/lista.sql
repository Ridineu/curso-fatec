-- 1

create or replace function

-- 2

CREATE OR REPLACE FUNCTION EhIdoso(pcod number)
return varchar2
as
	retorno varchar2(10);
	vidade number;
begin
	select idade into vidade
	from pacientes
	where rgpaciente = pcod;

	if vidade > 65 then
		retorno := 'IDOSO';
	else
		retorno := 'NAO IDOSO';
	end if;
	return retorno;
end;

begin 
	dbms_output.put_line(EhIdoso(1));
end;

-- 3

CREATE OR REPLACE FUNCTION Consulta_estoque(pcod number)
return number
as
	vqnt number;
begin
	select qtdestoq into vqnt
	from produto
	where cod_produto = pcod;
	
	return vqnt;
end;

begin
	dbms_output.put_line(Consulta_estoque(5));
end;

-- 4

create or replace function formata_telefone(tel varchar2)
return varchar2
as
	saida varchar(15);
begin
	

-- 5

create or replace function tipo_cliente(pcod number)
return varchar2
as 
	qntpedido number;
	saida varchar2(60);
	nome varchar(30);
begin
	select count(num_pedido) into qntpedido
	from pedido p
	where cod_cliente = pcod;
		
	if qntpedido > 3 then
		saida := 'Cliente preferencial';
	else
		if qntpedido >= 1 then 
			saida := 'Cliente normal';
		else
			saida := 'Cliente inativo';
		end if;
	end if;
	
	select nome_cliente into nome
	from cliente
	where cod_cliente = pcod;
	
	saida := saida || ' ' || nome || ' ' || pcod;
	
	return saida;
end;

begin 
	dbms_output.put_line(tipo_cliente(1));
end;




