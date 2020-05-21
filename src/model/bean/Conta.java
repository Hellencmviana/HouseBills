package model.bean;

public class Conta {
    String descricao, data, pagante;
    Double valor, juros;
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public Double getValor(){
        return valor;
    }
    
    public void setValor(Double valor){
        this.valor = valor;
    }
    
    public String getData(){
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public Double getJuros() {
        return juros;
    }
    
    public void setJuros(Double juros) {
        this.juros = juros;
    }
    
    public String getPagante(){
        return pagante;
    }
    
    public void setPagante(String pagante){
        this.pagante = pagante;
    }
}
