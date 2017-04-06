
import fatec.entidades.Aluno;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        DecimalFormat df = new DecimalFormat("#0.00");
        int aprovados=0;
        Aluno[] matAluno = new Aluno[2];
        
        for(int i=0; i<matAluno.length; i++){
            System.out.println("Informe o RA e depois o nome (um por linha): ");
            matAluno[i] = new Aluno(input.nextInt(), input.next());
            System.out.println("Informe a 1º nota e depois a 2ª (um por linha): ");
            matAluno[i].setNota1(input.nextDouble());
            matAluno[i].setNota2(input.nextDouble());
        }
        
        for(int i=0; i<matAluno.length; i++){
            System.out.print(matAluno[i].getRA() + " " + matAluno[i].getNome() + " " + matAluno[i].calcMedia() + " ");
            if(matAluno[i].isAprovado()){
                System.out.println("Aprovado");
                aprovados++;
            }else{
                System.out.println("Reprovado");
            } 
        }     
        
        System.out.println("Qtd. de aprovados: " + aprovados);
        System.out.println("Qtd. de reprovados: " + (matAluno.length - aprovados));
    }
    
}
