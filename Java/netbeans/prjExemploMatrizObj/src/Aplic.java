
import fatec.poo.model.Retangulo;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        DecimalFormat df = new DecimalFormat ("#0.00");
        
        Retangulo[] matRet = new Retangulo[3];
        
        for(int i=0; i < matRet.length; i++){
            System.out.println("Informe o valor da altura e depois da base: ");
            matRet[i] = new Retangulo(input.nextDouble(), input.nextDouble());
        }
        
        for(int i=0; i< matRet.length; i++){
            System.out.println("Contéudo do " + (i+1) + "º indexamento.");
            System.out.println("Valor da altura   : "+ df.format(matRet[i].getAltura()));
            System.out.println("Valor da base     : "+ df.format(matRet[i].getBase()));
            System.out.println("Valor da área     : "+ df.format(matRet[i].calcArea()));
            System.out.println("Valor da perímetro: "+ df.format(matRet[i].calcPerimetro()));
            System.out.println("Valor da diagonal : "+ df.format(matRet[i].calcDiagonal()) + "\n");
        }        
    }    
}
