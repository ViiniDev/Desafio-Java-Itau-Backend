public class TransactionDTO {
    @NotNull
    private double valor;
    @NotNull
    private String dataHora;

    public double getValor() {
        return valor;
    }
    public String getDataHora() {
        return dataHora;
    }
}