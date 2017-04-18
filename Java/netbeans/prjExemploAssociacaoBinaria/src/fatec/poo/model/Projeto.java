package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public class Projeto {
    private String Sigla, Descricao, DataInicio, DataTermino;
    private int qntFunc;
    private Funcionario funcionario[];
    
    public Projeto(String Sigla, String Descricao) {
        this.Sigla = Sigla;
        this.Descricao = Descricao;
        funcionario = new Funcionario[5];
    }

    public String getSigla() {
        return Sigla;
    }

    public String getDescricao() {
        return Descricao;
    }

    public String getDataInicio() {
        return DataInicio;
    }

    public String getDataTermino() {
        return DataTermino;
    }

    public void setDataInicio(String DataInicio) {
        this.DataInicio = DataInicio;
    }

    public void setDataTermino(String DataTermino) {
        this.DataTermino = DataTermino;
    }
    
    public void addFuncionario(Funcionario f){
        funcionario[qntFunc++] = f;
    }
    
    public void Listar(){
        System.out.println("\nSigla: " + Sigla + "\nDescrição: " + Descricao + "\nData inicio: " 
                           + DataInicio + "\nData termino: " + DataTermino 
                           + "\nQtd. Funcioanários: " + qntFunc);
        System.out.println("Registro\tNome\tDepartamento");
        for(int i=0; i<qntFunc; i++){
            System.out.println(funcionario[i].getRegistro() + "\t" + funcionario[i].getNome() 
                            + "\t" + funcionario[i].getDepartamento().getNome());
        }
        System.out.println("");
    }
}
