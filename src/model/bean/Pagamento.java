package model.bean;

public class Pagamento {
    String data, dataPagamento, dataVencimento;
    Double valorConta, valorPago, juros;
    int parcelamento, idPagamento, idPagante, idGrupo,idConta;
    
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    
    public int getIdPagante(){
        return idPagante;
    }
    
    public void setIdPagante(int idPagante){
        this.idPagante = idPagante;
    }
    
    public int getIdGrupo(){
        return idGrupo;
    }
    
    public void setIdGrupo(int idGrupo){
        this.idGrupo = idGrupo;
    }
    
    public int getIdConta(){
        return idConta;
    }
    
    public void setIdConta(int idConta){
        this.idConta = idConta;
    }
    
    public Double getValorConta(){
        return valorConta;
    }
    
    public void setValorConta(Double valorConta){
        this.valorConta = valorConta;
    }

    public Double getValorPago(){
        return valorPago;
    }
    
    public void setValorPago(Double valorPago){
        this.valorPago = valorPago;
    }

    public int getParcelamento(){
        return parcelamento;
    }
    
    public void setParcelamento(int parcelamento){
        this.parcelamento = parcelamento;
    }
    
    public String getDataPagamento() {
        return dataPagamento;
    }
    
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    public String getDataVencimento() {
        return dataVencimento;
    }
    
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public Double getJuros(){
        return juros;
    }
    
    public void setJuros(Double juros){
        this.juros = juros;
    }
    
}
