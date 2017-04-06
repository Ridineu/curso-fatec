
import fatec.poo.model.ContaCorrente;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        ContaCorrente[] matConta = new ContaCorrente[15];
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        int opcao, id, index=0;
        double valor;
        boolean flag;

        for (int i = 0; i < matConta.length; i++) {
            do {
                flag = true;
                System.out.println("Informe o número da " + (i+1) + "º conta: ");
                id = input.nextInt();

                for (int j = 0; j < i; j++) {
                    if (matConta[j].getNumero() == id) {
                        flag = false;
                    }
                }
                if (!flag) {
                    System.out.println("Número de conta já existente, tente com outro número!");
                }
            } while (!flag);

            System.out.println("Informe o valor da conta: ");
            valor = input.nextDouble();
            matConta[i] = new ContaCorrente(id, valor);
        }

        while (true) {
            System.out.println("\n1 - Sacar\n2 - Depositar\n3 - Consultar Saldo\n"
                    + "4 - Listar Contas\n5 - Sair");
            opcao = input.nextInt();

            if (opcao == 5) {
                break;
            } else {
                if (opcao == 4) {
                    System.out.println("\nNúmero da conta - Saldo");
                    for (int i = 0; i < matConta.length; i++) {
                        System.out.println(matConta[i].getNumero() + " - " + df.format(matConta[i].getSaldo()));
                    }
                } else {
                    if (opcao > 5) {
                        System.out.println("Opção inválida!");
                    } else {
                        
                        do {
                            flag = true;
                            System.out.println("Informe o número da conta: ");
                            id = input.nextInt();

                            for (int j = 0; j < matConta.length; j++) {
                                if (matConta[j].getNumero() == id) {
                                    flag = false;
                                    index = j;
                                }
                            }
                            if (flag) {
                                System.out.println("Número de conta não encontrado, tente novamente.");
                            }
                        } while (flag);
                        
                        if (opcao == 1) {
                            System.out.println("\nInforme o valor de saque: ");
                            valor = input.nextDouble();
                            if (valor > matConta[index].getSaldo()) {
                                System.out.println("Saldo insuficiente para este valor de saque.");
                            } else {
                                matConta[index].sacar(valor);
                            }
                        } else {
                            if (opcao == 2) {
                                System.out.println("Informe o valor para o deposito: ");
                                valor = input.nextDouble();
                                matConta[index].depositar(valor);
                            } else {
                                if (opcao == 3) {
                                    System.out.println("Saldo atual da conta: " + df.format(matConta[index].getSaldo()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }    
}
