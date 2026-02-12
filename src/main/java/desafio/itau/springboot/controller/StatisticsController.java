package desafio.itau.springboot.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.dto.StatisticsDTO;
import desafio.itau.springboot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/estatisticas")
public class StatisticsController {
    @Autowired(required = false)
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<StatisticsDTO> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsDTO(stats));
    }
}