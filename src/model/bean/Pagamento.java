package model.bean;

public class Pagamento {
    String nomePagante, tipoConta, dataPagamento;
    Double valorConta;
    int parcelamento, idPagamento;
    
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Double getValorConta(){
        return valorConta;
    }
    
    public void setValorConta(Double valorConta){
        this.valorConta = valorConta;
    }
    
    public String getNomePagante(){
        return nomePagante;
    }

    public void setNomePagante(String nomePagante){
        this.nomePagante = nomePagante;
    }

    public int getParcelamento(){
        return parcelamento;
    }

    public void setParcelamento(int parcelamento){
        this.parcelamento = parcelamento;
    }

    public String getDataPagamento(){
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento){
        this.dataPagamento = dataPagamento;
    }

    public String getTipoConta(){
        return tipoConta;
    }

    public void setTipoConta(String tipoConta){
        this.tipoConta = tipoConta;
    }
}
