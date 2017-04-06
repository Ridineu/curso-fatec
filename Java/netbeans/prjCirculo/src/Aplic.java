import fatec.poo.model.Circulo;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic {
    public static void main(String[] args) {        
       Circulo objCirculo = new Circulo();
       Scanner in = new Scanner (System.in);
       DecimalFormat formato = new DecimalFormat ("#0.00"); 
       
       System.out.println("Informe o raio: ");
       objCirculo.setRaio(in.nextDouble());       
       
       System.out.println("Area do circulo: " + formato.format(objCirculo.calcArea()));
       System.out.println("Perímetro do circulo: " + formato.format(objCirculo.calcPerimetro()));
       System.out.println("Diamtro do circulo: " + formato.format(objCirculo.calcPerimetro()));
    }    
}
