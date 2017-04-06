
import fatec.poo.model.Pessoa;
import fatec.poo.model.PessoaFisica;
import fatec.poo.model.PessoaJuridica;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Calendar cal = Calendar.getInstance();

        Pessoa[] matPessoa = new Pessoa[15];
        int opcao, ind = 0;
        
        while (true) {
            System.out.println("- 1 Cadastrar Pessoa Física");
            System.out.println("- 2 Cadastrar Pessoa Juridica");
            System.out.println("- 3 Listar");
            System.out.println("- 4 Sair");

            opcao = input.nextInt();

            if (opcao == 1) {
                if (ind > 14) {
                    System.out.println("Capacidade maxima atiguida!");
                } else {
                    System.out.println("Informe o CPF, nome e o ano de inscrição: (Um por linha):");
                    matPessoa[ind] = new PessoaFisica(input.next(), input.next(), input.nextInt());
                    System.out.println("Informe o valor base: ");                    
                    ((PessoaFisica)matPessoa[ind]).setBase(input.nextDouble());
                    ((PessoaFisica)matPessoa[ind++]).addCompras(somarCompras());
                }
            } else {
                if (opcao == 2) {
                    if (ind > 14) {
                        System.out.println("Capacidade maxima atiguida!");
                    } else {
                        System.out.println("Informe o CGC, nome e o ano de inscrição: (Um por linha):");
                        matPessoa[ind] = new PessoaJuridica(input.next(), input.next(), input.nextInt());
                        System.out.println("Informe o valor da taxa de incentivo: ");
                        ((PessoaJuridica)matPessoa[ind]).setTaxaIncentivo(input.nextDouble());
                        ((PessoaJuridica)matPessoa[ind++]).addCompras(somarCompras());
                    }
                } else {
                    if (opcao == 3) {
                        System.out.println("Tipo Pessoa  CPF/CGC      Nome       Ano de inscrição     Bonus");
                        for(int i=0; i<ind; i++){                           
                            if(matPessoa[i] instanceof PessoaFisica){
                                System.out.print("Pessoa Fisica "+ ((PessoaFisica)matPessoa[i]).getCPF()
                                        + " " + matPessoa[i].getNome() + " " 
                                        + df.format(((PessoaFisica)matPessoa[i]).calcBonus(cal.get(Calendar.YEAR))) + "\n");
                            }else{
                                System.out.print("Pessoa Juridica  " + ((PessoaJuridica)matPessoa[i]).getCGC()
                                        + " " + matPessoa[i].getNome() + " " 
                                        + df.format(((PessoaJuridica)matPessoa[i]).calcBonus(cal.get(Calendar.YEAR))) + "\n");
                            }
                        }
                    } else {
                        if (opcao == 4) {
                            break;
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                }
            }
        }
    }

    public static double somarCompras() {
        Scanner input = new Scanner(System.in);
        double add, retorno=0;
        while (true) {
            System.out.println("Informe o valor para adicionar em compras. (Informe zero (0) para parar)");
            add = input.nextDouble();
            if(add <= 0){
                return retorno;                
            }
            retorno += add;
        }
    }
}
