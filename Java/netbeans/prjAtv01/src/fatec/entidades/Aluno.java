package fatec.entidades;

public class Aluno {
    private int ra;
    private String nome;
    private double nota1, nota2;
    
    public Aluno(int id, String name){
        ra = id;
        nome = name;
    }
    
    public void setNota1(double nota){
        nota1 = nota;
    }    
    
    public void setNota2(double nota){
        nota2 = nota;
    }
    
    public double calcMedia(){
        return (nota1 + nota2) / 2.0;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getRA(){
        return ra;
    }
    
    public boolean isAprovado(){
        if(calcMedia() >= 6){
            return true;
        }
        return false;
    }  
}
