package fatec.poo.model;

import java.util.ArrayList;

public class Projeto {
    private String Sigla;
    private String Nome;
    private String DataInicio;
    private String DataTermino;
    private ArrayList<Funcionario> funcionarios;

    public Projeto(String Sigla, String Nome) {
        this.Sigla = Sigla;
        this.Nome = Nome;
        funcionarios = new ArrayList<Funcionario>();
    }

    public void setDataInicio(String DataInicio) {
        this.DataInicio = DataInicio;
    }

    public void setDataTermino(String DataTermino) {
        this.DataTermino = DataTermino;
    }

    public String getSigla() {
        return Sigla;
    }

    public String getNome() {
        return Nome;
    }

    public String getDataTermino() {
        return (DataTermino);
    }

    public String getDataInicio() {
        return (DataInicio);
    }

    public void addFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void listar() {
        System.out.println("\n\nSigla: " + Sigla);
        System.out.println("Descricao: " + Nome);
        System.out.println("Dt. Inicio:  " + DataInicio);
        System.out.println("Dt. Termino: " + DataTermino);
        System.out.println("Qtde. Func: " + funcionarios.size());
        System.out.println("\nRegistro\t\tNome\t\tDepartamento");

        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.print(funcionarios.get(i).getRegistro() + "\t\t");
            System.out.print(funcionarios.get(i).getNome() + "\t\t");
            System.out.println(funcionarios.get(i).getDepartamento().getNome() + "\t\t");            
        }
    }
}
