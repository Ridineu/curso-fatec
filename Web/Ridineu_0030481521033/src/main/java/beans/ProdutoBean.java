package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean {
	private Produto produto = new Produto();
	private ArrayList<Produto> listaProduto = new ArrayList<Produto>();
	private double totalVenda=0;
		
	public double getTotalVenda() {
		return totalVenda;
	}
	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ArrayList<Produto> getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(ArrayList<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public String salvar(){
		totalVenda += produto.getQnt() * produto.getValorUnit();
		listaProduto.add(produto);
		produto = new Produto();
		return "";
	}
	
	public String limpar(){
		totalVenda = 0;
		produto = new Produto();
		listaProduto = new ArrayList<Produto>();
		return "";
	}
}
