package model.bean;

public class Pagamento {
    String pagante, grupo, descricaoConta, data, dataPagamento, dataVencimento;
    Double valorConta, valorPago, juros;
    int parcelamento;
    
    public String getPagante(){
        return pagante;
    }
    
    public void setPagante(String pagante){
        this.pagante = pagante;
    }
    
    public String getGrupo(){
        return grupo;
    }
    
    public void setGrupo(String grupo){
        this.grupo = grupo;
    }
    
    public String getConta(){
        return descricaoConta;
    }
    
    public void setConta(String descricaoConta){
        this.descricaoConta = descricaoConta;
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
