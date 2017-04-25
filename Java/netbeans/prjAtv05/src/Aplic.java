import fatec.poo.model.Cliente;
import fatec.poo.model.Lancamento;
import java.util.Scanner;

/**
 *
 * @author 0030481521033
 */
public class Aplic {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Cliente clientes[] = new Cliente[5];
       int opcao, qnt=0, aux, iCli=0, codL=0;
       String CPF;
       boolean find;
       // qnt -> Quantidade de clientes do vetor clientes;
       while(true){
           System.out.println("Escolha a opção desejada:\n1 - Cadastrar Cliente\n2 - Apontar lançamento do cliente\n" +
                   "3 - Exibir lançamentos do cliente\n4 - Sair");
           opcao = input.nextInt();
           
           if(opcao == 4){
               break;
           }else{
               if(opcao > 4 || opcao < 1){
                   System.out.println("Opção inválida!");
               }else{
                   if(opcao == 1){
                       if(qnt == 5){
                           System.out.println("Capacidade máxima de clientes já atingida!");
                       }else{
                           System.out.println("Informe o CPF e o saldo do novo cliente.");
                           clientes[qnt] = new Cliente(qnt++, input.next(), input.nextDouble());
                       }
                   }else{
                       do{
                            System.out.println("Informe o CPF do cliente a realizar a ação: ");
                            CPF = input.next();
                            find=false;
                            aux=2;
                            for(int i=0; i<qnt; i++){
                                if(clientes[i].getCpf().equals(CPF)){
                                    find=true;
                                    iCli = i;
                                }
                            }
                            if(find){
                                System.out.println("Cliente encontrado!");
                                if(opcao == 2){
                                    System.out.println("Informe o tipo do lançamento [C - Crédito, D - Débito] " +
                                            "e o valor:");
                                    clientes[iCli].addLancamento(new Lancamento(++codL, input.next(), input.nextDouble()));
                                }else{
                                    clientes[iCli].exibirLancamento();
                                }
                            }else{
                                while(true){
                                    System.out.println("Cliente não encontrado, deseja informar outro CPF?\n1 - Sim\n" +
                                            "2 - Não (irá retornar ao menu inicial)");
                                    aux = input.nextInt();
                                    if(aux < 1 || aux > 2){
                                        System.out.println("Opçao inválida!");
                                    }else{
                                        break;
                                    }
                                }
                            }
                       }while(aux == 1);
                   }
               }
           }
       }      
    }    
}
