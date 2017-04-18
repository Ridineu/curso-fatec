package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public class Aluno extends Pessoa{
    
    private String ra;
    private int escolaridade;

    public Aluno(String ra, String nome) {
        super(nome);
        this.ra = ra;
    }    

    public String getRa() {
        return ra;
    }

    public int getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }
}
