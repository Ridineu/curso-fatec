
import fatec.poo.model.Funcionario;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import java.text.DecimalFormat;
import java.util.Random;

public class aplicMatrizObj {
    public static void main(String[] args) {
        Funcionario[] cadFun = new Funcionario[3];
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Random rm = new Random();
        
        cadFun[0] = new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978", 25.80);
        cadFun[1] = new FuncionarioMensalista(2020, "Leonardo Amaral", "20/06/2015", 2.80);
        cadFun[2] = new FuncionarioComissionado(3030, "Serjão Berranteiro", "21/03/2017", 0.085);
        
        cadFun[0].setCargo("Programador");
        cadFun[1].setCargo("Auxiliar Admistrativo");
        cadFun[2].setCargo("Vendedor");
        
        ((FuncionarioHorista)cadFun[0]).apontarHoras(60);
        ((FuncionarioMensalista)cadFun[1]).apontarValSalMin(680);
        ((FuncionarioComissionado)cadFun[2]).setSalBase(1500.50);
        
        for(int i=0, j=rm.nextInt(10); i<j; i++){
            ((FuncionarioComissionado)cadFun[2]).addVendas(rm.nextInt(6000));
        }
        
        for(int i=0; i<cadFun.length; i++){
            if(cadFun[i] instanceof FuncionarioHorista){
                System.out.println("Funcionário Horista:");
            }else{
                if(cadFun[i] instanceof FuncionarioMensalista){
                   System.out.println("Funcionário Mensalista:");
                }else{
                    System.out.println("Funcionário Comissionado: ");
                }
            }
            
            System.out.println("Registro        -> " + cadFun[i].getRegistro());
            System.out.println("Nome            -> " + cadFun[i].getNome());
            System.out.println("Data Admissão   -> " + cadFun[i].getDtAdmissao());
            System.out.println("Cargo           -> " + cadFun[i].getCargo());
            
            if(cadFun[i] instanceof FuncionarioHorista){
                System.out.println("Salario Bruto   -> " + df.format(((FuncionarioHorista)cadFun[i]).calcSalBruto())); 
            }else{
                if(cadFun[i] instanceof FuncionarioMensalista){
                    System.out.println("Salario Bruto   -> " + df.format(((FuncionarioMensalista)cadFun[i]).calcSalBruto())); 
                }else{
                    System.out.println("Salário Base    -> " + df.format(((FuncionarioComissionado)cadFun[i]).getSalBase()));
                    System.out.println("Taxa de comissão-> " + (((FuncionarioComissionado)cadFun[i]).getTaxaComissao())*100 + "%");
                    System.out.println("Total vendas    -> " + df.format(((FuncionarioComissionado)cadFun[i]).getTotalVendas()));
                    System.out.println("Salario Bruto   -> " + df.format(((FuncionarioComissionado)cadFun[i]).calcSalBruto()));
                }
            }
            
            if(cadFun[i] instanceof FuncionarioHorista){
                System.out.println("Gratificação    -> " + df.format(((FuncionarioHorista)cadFun[i]).calcGratificacao()));
            }else{
                if(cadFun[i] instanceof FuncionarioComissionado){
                    System.out.println("Gratificação    -> " + df.format(((FuncionarioComissionado)cadFun[i]).calcGratificacao()));
                    
                }                    
            }
            
            System.out.println("Desconto        -> " + df.format(cadFun[i].calcDesconto()));
            
            if(cadFun[i] instanceof FuncionarioHorista){
                System.out.println("Salario Liquido -> " + df.format(((FuncionarioHorista)cadFun[i]).calcSalLiquido())); 
            }else{
                if(cadFun[i] instanceof FuncionarioMensalista){
                    System.out.println("Salario Liquido -> " + df.format(((FuncionarioMensalista)cadFun[i]).calcSalLiquido())); 
                }else{
                    System.out.println("Salário Liquido -> " + df.format(((FuncionarioComissionado)cadFun[i]).calcSalLiquido()));
                }
            }
            System.out.println("\n");
        }
    }
    
}
