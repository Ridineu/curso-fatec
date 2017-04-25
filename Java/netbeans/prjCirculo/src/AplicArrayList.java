
import fatec.poo.model.Circulo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 0030481521033
 */
public class AplicArrayList {

    public static void main(String[] args) {
        ArrayList<Circulo> circulos = new ArrayList<Circulo>();
        DecimalFormat df = new DecimalFormat ("#0.00"); 
        Scanner in = new Scanner (System.in); 
        Circulo circulo;
        double raio;
        
        while(true){
            System.out.println("Informe o raio: ");
            raio = in.nextDouble();   
            
            if(!(raio > 0)){
                break;
            }
            
            circulo = new Circulo();
            circulo.setRaio(raio);
            
            circulos.add(circulo);
        }
    
        for(int i=0; i<circulos.size(); i++){
            System.out.println((i + 1) + "º Circulo");
            System.out.println("Raio: " + df.format(circulos.get(i).getRaio()));
            System.out.println("Area do circulo: " + df.format(circulos.get(i).calcArea()));
            System.out.println("Perímetro do circulo: " + df.format(circulos.get(i).calcPerimetro()));
            System.out.println("Diametro do circulo: " + df.format(circulos.get(i).calcDiametro()) + "\n");
        }
    
    }
    
}
