package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public class Professor extends Pessoa{
    private String regFunc;
    private int titularidade, areaAtuacao;

    public Professor(String regFunc, String nome) {
        super(nome);
        this.regFunc = regFunc;
    }

    public void setTitularidade(int titularidade) {
        this.titularidade = titularidade;
    }

    public void setAreaAtuacao(int areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getRegFunc() {
        return regFunc;
    }

    public int getTitularidade() {
        return titularidade;
    }

    public int getAreaAtuacao() {
        return areaAtuacao;
    }  
}
