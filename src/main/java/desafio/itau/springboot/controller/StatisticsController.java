@RestController
@RequestMapping ("/estatisticas")
public class StatisticsController {
    private final transactionService transactionService;
    public StatisticsController(transactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping
    public ResponseEntity<StatisticsDTO> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsDTO(stats));
    }
}