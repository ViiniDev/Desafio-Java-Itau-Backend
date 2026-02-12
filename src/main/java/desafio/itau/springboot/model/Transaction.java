public class Transaction {
    private double valor;
    private OffsetDataTime dataHora;
    

    public Transaction(final double valor, final OffsetDataTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }
    public OffsetDataTime getDataHora() {
        return dataHora;
    }
s
    
}