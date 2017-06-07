-- para ativar/desativar uma trigger

alter trigger nome enable;
alter trigger nome disable;

-- Tabela destino

create table LogTest(
	NrLog number(5,0) primary key,
	dttrans date,
	usuario varchar2 (100),
	opera varchar(1) check (opera in ('I', 'A', 'E')) );
	
-- Como no oracle não possui auto incremento direto, é necessário criar uma sequencia
  -- para fazer o auto incremento.

  create sequence seglog;  
  
  --toda vez que um produto for excluido, gravar um registro na tab logtest
  
create or replace trigger elimina_prop before delete on produto for each row
begin
	insert into logtest values(seglog.nextval, sysdate, user, 'E');
end;

-- toda vez que um produto for inserido ou desc for alterada, gravar um registro
-- na tabela logteste

create or replace trigger elimina_prop2 before insert or update of descricao
 on produto for each row
begin
	if inserting then
		insert into logtest values(seglog.nextval, sysdate, user, 'I');
	else
		insert into logtest values(seglog.nextval, sysdate, user, 'E');
	end if;
end;

-- toda vez que um produto for inserido ou descricao do produto for alterada ou o 
-- produto for excluido, grave um registro na tab logtest

create or replace trigger elimina_prop3 before insert or update of descricao
 or delete on produto for each row
begin
	if inserting then
		insert into logtest values(seglog.nextval, sysdate, user, 'I');
	else 
		if updating then
			insert into logtest values(seglog.nextval, sysdate, user, 'A');
		else	
			insert into logtest values(seglog.nextval, sysdate, user, 'E');
		end if;
	end if;
end;

-- exiba um mensagem de erro se o usuário tentar excluir ou alterar um cliente
-- antes das 7:00 e depois das 14:00. Usando o raise_application_error

create or replace trigger verif_hora before update or delete on cliente
for each row
begin
	if to_char(sysdate, 'HH24') not between 7 and 14 then
		if updating then
			raise_application_error(-20001, 'atualizao nao permitida neste horário');
		else
			raise_application_error(-20001,'exclusão nao permitida neste horário');
		end if;
	end if;
end;

-- ao inserir um novo pedido, ubstitua o prazo_entrega informado pela
-- data de hoje + 15 dias.

create or replace trigger ins_pedido before insert on pedido
for each row
begin
	:new.prazo_entrega := sysdate + 15;	
end;

/*
	O comando ':new.' é feito para alterar uma coluna em uma instrução,
	ele acontece em tempo de execução.	
	-- Explicao professora:
		Em um trigger de linha existe uma forma de acessar os campos que
		estão sendo acessados atualmente através dos qualificadores:
		:new e :old.
		
		Tabela de valores das variáveis :new e :old
					:new					:old
		INSERT		Valores que estão		null
					sendo incluídos
		
		UPDATE		Valores já modifica-    valores originais antes
					dos.					da modificação
					
		DELETE		null					valores antes da exclusão.
		
*/


-- ao incluir um novo produto, substitua o vlaor unitario informado 
-- pelo mesmo valor c/ 10% de desconto

create or replace trigger ins_produto 
before insert on produto
for each row
begin
	:new.valor_produto := :new.valor_produto * 0.9;
end;

-- ao alterar um prazo de entrega de um pedido, grave em uma tablea o prazo antigo
-- o prazo novo e o nome do cliente que fez o pedido em questão.

create table execTrigger(
	anterior date,
	nova date,
	nome varchar2(100) );

create or replace trigger update_pedido
before update of prazo_entrega on pedido
for each row
declare	nome varchar(100);
begin

	select nome_cliente into nome
	from cliente
	where cod_cliente = :new.cod_cliente;

	insert into execTrigger 
	values(:old.prazo_entrega, :new.prazo_entrega, nome);
end;






	
	
	

