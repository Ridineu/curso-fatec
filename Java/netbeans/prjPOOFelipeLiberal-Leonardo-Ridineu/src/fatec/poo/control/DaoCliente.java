package fatec.poo.control;

import fatec.poo.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCliente {
    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbcliente(CPF, Nome, Endereco, Cidade, CEP, UF, Telefone_DDD, Telefone_Numero, " +
                                        "Limite_Credito, Limite_Disponivel) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getUf());
            ps.setString(7, cliente.getDdd());
            ps.setString(8, cliente.getTelefone());
            ps.setDouble(9, cliente.getLimiteCred());
            ps.setDouble(10, cliente.getLimiteDisp());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString() + "em daoCliente");   
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbcliente set Nome = ?, Endereco = ?, Cidade = ?, CEP = ?, " +
                                            "UF = ?, Telefone_DDD = ?, Telefone_Numero = ?, Limite_Credito = ?, " +
                                                 "Limite_Disponivel = ? where CPF = ?");
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getUf());
            ps.setString(6, cliente.getDdd());
            ps.setString(7, cliente.getTelefone());
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            ps.setString(10, cliente.getCpf());
           
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString() + "em daoCliente");   
        }
    }
    
    public  Cliente consultar (String cpf) {
        Cliente c = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbcliente where " +
                                                 "CPF = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                c = new Cliente (cpf, rs.getString("Nome"), rs.getDouble("Limite_Credito"));
                c.setEndereco(rs.getString("Endereco"));
                c.setCidade(rs.getString("Cidade"));
                c.setUf(rs.getString("UF"));
                c.setDdd(rs.getString("Telefone_DDD"));
                c.setTelefone(rs.getString("Telefone_Numero"));
                c.setCep(rs.getString("CEP"));
                c.setLimiteDisp(rs.getDouble("Limite_Disponivel"));
            }
        }
        catch (SQLException ex) { 
            System.out.println(ex.toString() + "em daoCliente");    
        }
        return (c);
    }
    
    public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbcliente where CPF = ?");
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString() + "em daoCliente");  
        }
    }
}
