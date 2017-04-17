package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Time {
	@Id
	private int codigo;
	private String nome, mascote, estadioProprio, corUniforme;
	private int qntEstadio;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMascote() {
		return mascote;
	}
	public void setMascote(String mascote) {
		this.mascote = mascote;
	}
	public String getEstadioProprio() {
		return estadioProprio;
	}
	public void setEstadioProprio(String estadioProprio) {
		this.estadioProprio = estadioProprio;
	}
	public String getCorUniforme() {
		return corUniforme;
	}
	public void setCorUniforme(String corUniforme) {
		this.corUniforme = corUniforme;
	}
	public int getQntEstadio() {
		return qntEstadio;
	}
	public void setQntEstadio(int qntEstadio) {
		this.qntEstadio = qntEstadio;
	}	
}
