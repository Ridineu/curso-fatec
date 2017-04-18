
import fatec.poo.model.Aluno;
import fatec.poo.model.Curso;
import fatec.poo.model.Professor;
import fatec.poo.model.Turma;

/**
 *
 * @author 0030481521033
 */
public class Aplic {

    public static void main(String[] args) {
        Curso curso = new Curso("POO", "Programação orientada a objetos", "80hrs");        
        Professor pf = new Professor("054A", "Dimas Cardoso");
        
        Aluno a1 = new Aluno("01", "Yasmin");
        Aluno a2 = new Aluno("02", "Micaele");
        Aluno a3 = new Aluno("03", "Tamires");
        Aluno a4 = new Aluno("04", "Thaynara");
        Aluno a5 = new Aluno("05", "Larissa");
        
        Turma tm = new Turma("D15-2", 40);
        tm.setCurso(curso);
        tm.setProfessor(pf);
        tm.addAluno(a1);
        tm.addAluno(a2);
        tm.addAluno(a3);
        tm.addAluno(a4);
        tm.addAluno(a5);
        
        tm.listarAlunos();
    }
    
}
