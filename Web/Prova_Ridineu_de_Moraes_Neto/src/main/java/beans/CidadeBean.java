package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.CidadeDAO;
import entidades.Cidade;

@ManagedBean
@SessionScoped
public class CidadeBean {
	private Cidade cidade = new Cidade();
    private CidadeDAO cidadeDAO = new CidadeDAO();
    private List <Cidade> cidades;
    
    public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
    
    public List<Cidade> getListaCid() {
		if(cidades == null)
			cidades = cidadeDAO.getAllCidades();
		
		return cidades;
	}	

	public String salvar(){
		cidadeDAO.salvar(cidade);
		cidades = cidadeDAO.getAllCidades();
		cidade = new Cidade();
		return "";
	}
}
