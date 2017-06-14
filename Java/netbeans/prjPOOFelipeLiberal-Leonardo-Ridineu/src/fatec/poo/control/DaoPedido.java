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

import fatec.poo.model.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author 0030481521033
 */
public class DaoPedido {
    private Connection connection;
    private DaoCliente daocliente;
    private DaoVendedor daovendedor;
    private DaoItemPedido daoitem;
    
    public DaoPedido(Connection connection) {
        this.connection = connection;
        daocliente = new DaoCliente(connection);
        daovendedor = new DaoVendedor(connection);
        daoitem = new DaoItemPedido(connection);
    }
    
    public Pedido consultar(Integer numero){
        Pedido pedido = null;
        PreparedStatement ps = null;
        Cliente cliente;
        Vendedor vendedor;
        
        try {
            ps = connection.prepareStatement("SELECT * FROM tbpedido where numero = ?");
            
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pedido = new Pedido(numero, rs.getString("DataPedido"));
                if(rs.getString("Status").equals("1"))
                    pedido.setStatus(true);
                else
                    pedido.setStatus(false);                
                pedido.setDataPagto(rs.getString("DataPagto"));  
                
                cliente = daocliente.consultar(rs.getString("CPFCliente"));
                pedido.setCliente(cliente);
                cliente.addPedido(pedido);

                vendedor = daovendedor.consultar(rs.getString("CPFVendedor"));
                pedido.setVendedor(vendedor);
                vendedor.addPedido(pedido);
                
                pedido.setItensPedido(daoitem.consultar(rs.getInt("Numero")));
                for(int i=0; i<pedido.getItensPedido().size(); i++){
                   pedido.getItensPedido().get(i).setPedido(pedido);
                }                   
            }
        } catch (SQLException e) {
            System.out.println(e.toString() + " em daoPedido");
        }
        
        return pedido;
    }
    
    public void inserir(Pedido pedido){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO tbpedido(Numero, Status, DataPedido, DataPagto, CPFCliente, CPFVendedor) VALUES(?,?,?,?,?)");
            
            ps.setInt(1, pedido.getNumero());
            ps.setString(2, "1");
            ps.setString(3, pedido.getDataEmissaoPedido());
            ps.setString(4, pedido.getDataPagto());
            ps.setString(5, pedido.getCliente().getCpf());
            ps.setString(6, pedido.getVendedor().getCpf());
            
            ps.execute();
            
            daocliente.alterar(pedido.getCliente());
            daovendedor.alterar(pedido.getVendedor());
            
            for(int i=0; i<pedido.getItensPedido().size(); i++){
                daoitem.inserir(pedido.getItensPedido().get(i));
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString() + " em daopedido");
        }
    }
    
    public void excluir(Pedido pedido){
        PreparedStatement ps = null;
        
        try {
            pedido = consultar(pedido.getNumero());
            pedido.getCliente().setLimiteDisp(pedido.getCliente().getLimiteDisp() +
                        pedido.calcCustoTotal());
            
            daocliente.alterar(pedido.getCliente());
            
            for(int i=0; i<pedido.getItensPedido().size(); i++){
                daoitem.excluir(pedido.getItensPedido().get(i));
            }
             
            ps = connection.prepareStatement("DELETE FROM tbpedido WHERE Numero = ?");
            ps.setInt(1, pedido.getNumero());
            
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println(e.toString() + " em daopedido");
        }
        
    }
    
    public void alterar(Pedido pedido){
        PreparedStatement ps = null;
        try {            
           daocliente.alterar(pedido.getCliente());
           
           Pedido pedidoOriginal = consultar(pedido.getNumero());
           
           for(int i=0; i<pedidoOriginal.getItensPedido().size(); i++){
               daoitem.excluir(pedidoOriginal.getItensPedido().get(i));
           } 
           
           for(int i=0; i<pedido.getItensPedido().size(); i++){
               daoitem.inserir(pedido.getItensPedido().get(i));
           }
            
           daocliente.alterar(pedido.getCliente());
        } catch (Exception e) {
            System.out.println(e.toString() + " em daopedido");
        }
    }
  
}
