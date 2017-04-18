package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public class Departamento {
    private String Sigla, Nome;
    private Funcionario funcionarios[];
    private int qtdeFunc;
        
    public Departamento(String Sigla, String Nome) {
        this.Sigla = Sigla;
        this.Nome = Nome;
        funcionarios = new Funcionario[5];
        
    }
    
    public String getSigla() {
        return Sigla;
    }

    public String getNome() {
        return Nome;
    }
    
    public void addFuncionario(Funcionario f){
        funcionarios[qtdeFunc++] = f;
    }
    
    public void listar(){
        System.out.println("\nSigla: " + Sigla + "\nNome: " + Nome + "\nQuantidade de funcionários: " + qtdeFunc);
        System.out.println("Registro | Nome  | Tipo");
        for(int i=0; i<qtdeFunc; i++){
            System.out.print(funcionarios[i].getRegistro() + " | " + funcionarios[i].getNome() + " | Funcionário ");
            if(funcionarios[i] instanceof FuncionarioComissionado){
                System.out.println("Comissionado");
            }else{
                if(funcionarios[i] instanceof FuncionarioHorista){
                    System.out.println("Horista");
                }else{
                    System.out.println("Mensalista");
                }                    
            }
        }
        System.out.println("");
    }
}
