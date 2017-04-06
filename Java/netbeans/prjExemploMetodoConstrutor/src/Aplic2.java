
import fatec.poo.model.Retangulo;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic2 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);       
        DecimalFormat df = new DecimalFormat("#0.00");
        
         /*        
        double medAlt, medBase;
        
        System.out.println("Informe a altura: ");
        medAlt = input.nextDouble();
        System.out.println("Informe a base: ");
        medBase = input.nextDouble();
        
        Retangulo objRet = new Retangulo(medAlt, medBase);          
        */
         
        Retangulo objRet = new Retangulo(input.nextDouble(), input.nextDouble());  
        
        System.out.println("Altura   : " + df.format(objRet.getAltura()));
        System.out.println("Base     : " + df.format(objRet.getBase()));
        System.out.println("Área     : " + df.format(objRet.calcArea()));
        System.out.println("Perímetro: " + df.format(objRet.calcPerimetro()));
        System.out.println("Diagonal : " + df.format(objRet.calcDiagonal()));
    }    
}
