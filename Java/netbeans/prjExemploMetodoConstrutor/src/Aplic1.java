import fatec.poo.model.Retangulo;

public class Aplic1 {
    public static void main(String[] args) {
        Retangulo objRet = new Retangulo(3.0, 4.0);
        
        System.out.println("Altura   : " + objRet.getAltura());
        System.out.println("Base     : " + objRet.getBase());
        System.out.println("Área     : " + objRet.calcArea());
        System.out.println("Perímetro: " + objRet.calcPerimetro());
        System.out.println("Diagonal : " + objRet.calcDiagonal());
    }    
}
