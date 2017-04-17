package entidades;

public class Carro {
	private String placa, modelo, docEmDia;
	private int ano;
	
	public String getPlaca(){
		return placa;
	}	
	public void setPlaca(String placa){
		this.placa = placa;
	}		
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDocEmDia(){
		return docEmDia;
	}	
	public void setDocEmDia(String docEmDia){
		this.docEmDia = docEmDia;
	}
	public int getAno(){
		return ano;
	}	
	public void setAno (int ano){
		this.ano = ano;
	}
}
