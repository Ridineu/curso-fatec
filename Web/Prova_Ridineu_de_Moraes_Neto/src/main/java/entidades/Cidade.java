package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade {
	@Id
	private int codigo;
	private String nome, estado;
	private int anoFund, populacao;
	public String getNome() {
		return nome;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getAnoFund() {
		return anoFund;
	}
	public void setAnoFund(int anoFund) {
		this.anoFund = anoFund;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}	
}
