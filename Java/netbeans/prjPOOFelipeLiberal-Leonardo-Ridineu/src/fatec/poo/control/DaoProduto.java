/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe Liberal
 */
public class DaoProduto {
    private Connection conn;
    
    public DaoProduto(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbproduto(CodigoProduto, Descricao, QtdeDisponivel, PrecoUnit, EstoqueMinimo) VALUES(?,?,?,?,?)");
                 
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQtdeDisponivel());
            ps.setDouble(4, produto.getPrecoUnit());
            ps.setInt(5, produto.getEstoqueMin());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbproduto set Descricao = ?, QtdeDisponivel = ?, PrecoUnit = ?, EstoqueMinimo = ? where CodigoProduto = ?");
                                   
           
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQtdeDisponivel());
            ps.setDouble(3, produto.getPrecoUnit());
            ps.setInt(4, produto.getEstoqueMin());
           
            ps.setInt(5, produto.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public  Produto consultar (int codigo) {
        Produto p = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbproduto where " +
                                                 "CodigoProduto = ?");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                p = new Produto (codigo, rs.getString("Descricao"));
                p.setQtdeDisponivel(rs.getInt("QtdeDisponivel"));
                p.setPrecoUnit(rs.getInt("PrecoUnit"));
                p.setEstoqueMin(rs.getInt("EstoqueMinimo"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (p);
    }
    
    public void excluir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbproduto where CodigoProduto = ?");
            
            ps.setInt(1, produto.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
