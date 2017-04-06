package fatec.poo.model;

public class Retangulo {
    private double altura, base;
    
    public Retangulo(double a, double b){
        altura = a;
        base = b;
    }
    
    public void setAltura(double a){
        altura = a;
    }
    public void setBase(double a){
        base = a;
    }
    public double calcArea(){
        return altura * base;
    }
    public double calcPerimetro(){
        return (altura + base) * 2;
    }      
    public double calcDiagonal(){
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }
    
    public double getAltura(){
        return altura;
    }
    
    public double getBase(){
        return base;
    }
}