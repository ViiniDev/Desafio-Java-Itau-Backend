@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public void clearTransactions() {
        transactions.clear();
    }
    public StaticsDTO getStatistics() {
        DoubleSummaryStatistics statistics = transactions.stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
        return new StaticsDTO(statistics);
    }

}