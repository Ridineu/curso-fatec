package fatec.poo.model;
/**
 *
 * @author 0030481521033
 */
public class Circulo {
    private double Raio;

    public void setRaio(double r) {
        Raio = r;
    }

    public double calcArea() {
        return Math.PI * Math.pow(Raio, 2);
    }
    
    public double calcPerimetro(){
        return 2 * Math.PI * Raio;
    }
    
    public double calcDiametro(){
        return 2 * Raio;
    }

    public double getRaio(){
	return Raio;	
    }
}
