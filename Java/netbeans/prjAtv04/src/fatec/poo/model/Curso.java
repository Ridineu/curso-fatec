
package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public class Curso {
    private String sigla, descricao, cargaHoraria;

    public Curso(String sigla, String descricao, String cargaHoraria) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }        
}
