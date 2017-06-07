/* 

Criar uma store procedure que exclua um cliente. Passar o código do cliente como parâmetro.
Verificar se o clien te existe: se existir, exibir "cliente excluído com sucesso"; se não existir,
exibir "cliente inválido!".

*/

create or replace procedure p_ExcluirCliente(clicod number)
as
begin
	delete from cliente
	where cod_cliente = clicod;
	
	if sql%rowcount = 0 then	 
		insert into tab_erro values(sysdate, 'cliente inválido!');
		/*
			raise_application_error(-20001, 'Cliente inválido@'); 
		*/
	else
		insert into tab_erro values(sysdate, 'cliente excluído com sucesso');
	end if;
	commit;
end;

insert into cliente values(10, null, null, null, null, null);

select * from cliente where cod_cliente = 10;

exec p_excluircliente(10);

delete from tab_erro;

select * from tab_erro;
