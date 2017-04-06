import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import java.text.DecimalFormat;

/**
 *
 * @author 0030481521022
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        FuncionarioHorista funchor = new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978", 15.80);
        FuncionarioMensalista funcmen = new FuncionarioMensalista(2020, "Leonardo Amaral", "20/06/2015", 2.50);
        FuncionarioComissionado funccom = new FuncionarioComissionado(3030, "Serjão Berranteiro", "21/03/2017", 0.10);
        
        funchor.apontarHoras(90);
        funchor.setCargo("Gerente");
        funcmen.apontarValSalMin(680);
        funcmen.setCargo("Coordenador");
        funccom.setSalBase(1000.00);
        funccom.setCargo("Assistente administrativo");
        funccom.addVendas(3000.00);
        funccom.addVendas(2000.00);
        funccom.addVendas(5000.00);
        
        System.out.println("Funcionário Horista:");
        System.out.println("Registro        => " + funchor.getRegistro());
        System.out.println("Nome            => " + funchor.getNome());
        System.out.println("Data Admissão   => " + funchor.getDtAdmissao());
        System.out.println("Cargo           => " + funchor.getCargo());
        System.out.println("Salario Bruto   => " + df.format(funchor.calcSalBruto()));
        System.out.println("Desconto        => " + df.format(funchor.calcDesconto()));
        System.out.println("Gratificação    => " + df.format(funchor.calcGratificacao()));
        System.out.println("Salario Liquido => " + df.format(funchor.calcSalLiquido()));
        
        System.out.println("\nFuncionário Mensalista:");
        System.out.println("Registro        => " + funcmen.getRegistro());
        System.out.println("Nome            => " + funcmen.getNome());
        System.out.println("Data Admissão   => " + funcmen.getDtAdmissao());
        System.out.println("Cargo           => " + funcmen.getCargo());
        System.out.println("Salario Bruto   => " + df.format(funcmen.calcSalBruto()));
        System.out.println("Desconto        => " + df.format(funcmen.calcDesconto()));
        System.out.println("Salario Liquido => " + df.format(funcmen.calcSalLiquido()));
        
        System.out.println("\nFuncionário Comissionado:");
        System.out.println("Registro        => " + funccom.getRegistro());
        System.out.println("Nome            => " + funccom.getNome());
        System.out.println("Data Admissão   => " + funccom.getDtAdmissao());
        System.out.println("Cargo           => " + funccom.getCargo());
        System.out.println("Salario Bruto   => " + df.format(funccom.calcSalBruto()));
        System.out.println("Desconto        => " + df.format(funccom.calcDesconto()));
        System.out.println("Gratificação    => " + df.format(funccom.calcGratificacao()));
        System.out.println("Salario Liquido => " + df.format(funccom.calcSalLiquido()));
    }
    
}
