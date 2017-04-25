package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public class Turma {
    private String sigla;
    private int qtdVagas, qntAluno;
    private Curso curso;
    private Professor professor;
    private Aluno alunos[];

    public Turma(String sigla, int qtdVagas) {
        this.sigla = sigla;
        this.qtdVagas = qtdVagas;
        alunos = new Aluno[qtdVagas];
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
        
    public Curso getCurso() {
        return curso;
    }

    public Professor getProfessor() {
        return professor;
    }    
    
    public void addAluno(Aluno aluno){
        alunos[qntAluno++] = aluno;
    }

    public int getQtdVagas() {
        return qtdVagas;
    } 
    
    public void listarAlunos(){
        System.out.println("Lista de Frequência");
        System.out.println("Sigla do curso: " + curso.getSigla() + "\nNome do curso: " + curso.getDescricao());
        System.out.println("Sigla de turma: " + sigla);
        System.out.println("Nome professor: " + professor.getNome() + "\n\n\tNome Alunos\n");
        
        for(int i=0; i<qntAluno; i++){
            System.out.println((i + 1) + "- " + alunos[i].getNome());
        }
        System.out.println("");
    }
    
    
}
