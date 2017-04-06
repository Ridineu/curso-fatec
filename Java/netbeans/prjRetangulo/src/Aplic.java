import fatec.poo.model.Retangulo;

public class Aplic {
    public static void main(String[] args) {
        Retangulo objRet = new Retangulo();
        
        objRet.setAltura(5.0);
        objRet.setBase(8.0);
        
        System.out.println("Area: "+ objRet.calcArea());
        System.out.println("Perimetro: "+ objRet.calcPerimetro());
    }    
}
