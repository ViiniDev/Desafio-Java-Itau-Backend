@RestController
@RequestMapping("/transacao")
public class TransactionController {
    public TransactionController(TransactionController transactionController) {
        this.transactionController = transactionController;
    }

    @PostMapping
    public ResponseEntity<TransactionController> createTransaction(@Valid @RequestBody TransactionController transactionController) {
        if(transactionController.getDataHora().isAfter(OffsetDateTime.now()) || transactionController.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(transactionController.getValor(), transactionController.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();    
    }
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok.build();
    }
}