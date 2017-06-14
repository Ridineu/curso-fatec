/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.ItemPedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Pedido;
import java.util.ArrayList;

/**
 *
 * @author 0030481521033
 */
public class DaoItemPedido {
        
    private Connection connection;
    private DaoProduto daoproduto;
    
    public DaoItemPedido(Connection connection) {
        this.connection = connection;
        daoproduto = new DaoProduto(connection);
    }
    
    public ArrayList<ItemPedido> consultar(Integer numeroPedido){
        ArrayList<ItemPedido> arrayItens = new ArrayList<ItemPedido>();
        ItemPedido itempedido;
        
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement("SELECT * FROM tbitem_pedido WHERE NumeroPedido = ?");
            
            ps.setInt(1, numeroPedido);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                itempedido = new ItemPedido(0, rs.getInt("QtVendida"));
                itempedido.setProduto(daoproduto.consultar(rs.getInt("CodigoProduto")));
                arrayItens.add(itempedido);
            }
            
        } catch (SQLException e) {
             System.out.println(e.toString() + " em daoItemPedido");
        }
        
        return arrayItens;
    }
    
    public void inserir(ItemPedido itempedido){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO tbitem_Pedido(NumeroPedido, CodigoProduto, QtVendida " +
                                        "VALUES(?,?,?)");
            
            ps.setInt(1, itempedido.getPedido().getNumero());
            ps.setInt(2, itempedido.getProduto().getCodigo());
            ps.setInt(3, itempedido.getQtdeVendida());
                      
            ps.execute();
            
            daoproduto.alterar(itempedido.getProduto());
            
        } catch (SQLException ex) {
             System.out.println(ex.toString() + "em daoItemPedido");   
        }
    }
    
    public void excluir(ItemPedido itempedido){
        
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement("DELETE FROM tbitem_Pedido "+
                                        "WHERE NumeroPedido = ? AND CodigoProduto = ? AND QtVendida = ?");
            
            ps.setInt(1, itempedido.getPedido().getNumero());
            ps.setInt(2, itempedido.getProduto().getCodigo());
            ps.setInt(3, itempedido.getQtdeVendida());
                      
            ps.execute();
            
            daoproduto.alterar(itempedido.getProduto());
            
        } catch (SQLException ex) {
             System.out.println(ex.toString() + "em daoItemPedido");   
        }
    }
    
}
