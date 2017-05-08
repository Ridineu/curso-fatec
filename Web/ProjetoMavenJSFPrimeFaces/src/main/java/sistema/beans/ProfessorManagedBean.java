package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class ProfessorManagedBean {
	
	private Professor professor = new Professor();
	private List<Professor> professores;
	private ProfessorService service = new ProfessorService();
	
	public void onRowEdit(RowEditEvent e){
		Professor p = ((Professor) e.getObject());
		service.alterar(p);
	}
	
	public void salvar(){
		service.salvar(professor);
		if(professor != null)
			professores.add(professor);
		professor = new Professor();
	}
	
	public Professor getProfessor(){
		return professor;
	}
	
	public void setProfessor(Professor p){
		this.professor = p;
	}
	
	public List<Professor> getProfessores(){
		if(professores == null)
			professores = service.getProfessores();
		
		return professores;
	}
	
	public void remover(Professor p){
		service.remover(p);
		professores.remove(p);		
	}
}
