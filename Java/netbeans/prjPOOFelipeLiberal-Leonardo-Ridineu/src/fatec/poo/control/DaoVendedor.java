package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Vendedor;

public class DaoVendedor {
    private Connection connection;
    
    public DaoVendedor(Connection connection){
        this.connection = connection;
    }
    
    public void inserir(Vendedor vendedor){
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement("INSERT INTO tbvendedor(CPF, Nome, Endereco, Cidade, " +
                               "CEP, UF, Telefone_DDD, Telefone_Numero, Salario_Base, Comissao) " +
                               "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            ps.setString(1, vendedor.getCpf());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getEndereco());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getCep());
            ps.setString(6, vendedor.getUf());
            ps.setString(7, vendedor.getDdd());
            ps.setString(8, vendedor.getTelefone());
            ps.setDouble(9, vendedor.getSalarioBase());
            ps.setDouble(10, vendedor.getComissao());
            
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString() + " em daoVendedor");
        }
    }
    
    public void alterar(Vendedor vendedor){
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement("UPDATE tbvendedor set Nome = ?, Endereco = ?, Cidade = ?, " +
                    "CEP = ?, UF = ?, Telefone_DDD = ?, Telefone_Numero = ?, Salario_Base = ?, Comissao = ? " +
                    "where CPF = ?");
            
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getEndereco());
            ps.setString(3, vendedor.getCidade());
            ps.setString(4, vendedor.getCep());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getDdd());
            ps.setString(7, vendedor.getTelefone());
            ps.setDouble(8, vendedor.getSalarioBase());
            ps.setDouble(9, vendedor.getComissao());
            ps.setString(10, vendedor.getCpf());
            
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString() + " em daoVendedor");
        }
    }
    
    public Vendedor consultar(String CPF){
        Vendedor vendedor = null;
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement("SELECT * from tbvendedor where CPF = ?");
                
            ps.setString(1, CPF);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                vendedor = new Vendedor(CPF, rs.getString("Nome"), rs.getDouble("Salario_Base"));
                vendedor.setDdd(rs.getString("Telefone_DDD"));
                vendedor.setTelefone(rs.getString("Telefone_Numero"));
                vendedor.setEndereco(rs.getString("Endereco"));
                vendedor.setCidade(rs.getString("Cidade"));
                vendedor.setUf(rs.getString("UF"));
                vendedor.setCep(rs.getString("CEP"));
                vendedor.setComissao(rs.getDouble("Comissao"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString() + " em daoVendedor");
        }
        
        return (vendedor);
    }
    
    public void excluir(Vendedor vendedor){
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement("DELETE FROM tbvendedor where CPF = ?");
            ps.setString(1, vendedor.getCpf());
            ps.execute();
            
        } catch (SQLException e) {
           System.out.println(e.toString() + " em daoVendedor");
        }
    }
}