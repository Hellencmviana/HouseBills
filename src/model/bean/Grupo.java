package model.bean;

public class Grupo {
    String nomeGrupo, endereco, telefone;
    int idGrupo;
    
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    public String getNomeGrupo(){
        return nomeGrupo;
    }
    
    public void setNomeGrupo(String nomeGrupo){
        this.nomeGrupo = nomeGrupo;
    }
    
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
