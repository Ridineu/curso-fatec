/**
 *
 * @author aluno
 */
public class Exemplo6 {
    public static void main(String[] args) {
       int Soma=0, i=1;
       
       do{
           Soma += i;
           i++;
       }while(i <= 100);
       
       System.out.println("A soma de 1 a 100 eh: " + Soma);
    }
}
