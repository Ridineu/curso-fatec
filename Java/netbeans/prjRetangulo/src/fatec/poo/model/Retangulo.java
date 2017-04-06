package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */

public class Retangulo {
    private double Altura, Base;
    
    public void setAltura(double a){
        Altura = a;
    }
    public void setBase(double a){
        Base = a;
    }
    public double calcArea(){
        return Altura * Base;
    }
    public double calcPerimetro(){
        return (Altura + Base) * 2;
    }             
}