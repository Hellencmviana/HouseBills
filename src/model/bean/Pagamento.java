package model.bean;

public class Pagamento {
    String data, pagante, dataPagamento;
    Double valorPagamento, parcelamento;
    
    public Double getValorPagamento(){
        return valorPagamento;
    }
    
    public void setValorPagamento(Double valorPagamento){
        this.valorPagamento = valorPagamento;
    }
    
    public Double getParcelamento(){
        return parcelamento;
    }
    
    public void setParcelamento(Double parcelamento){
        this.parcelamento = parcelamento;
    }
    
    public String getPagante(){
        return pagante;
    }
    
    public void setPagante(String pagante){
        this.pagante = pagante;
    }
    
    public String getdataPagamento() {
        return dataPagamento;
    }
    
    public void setdataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
}
