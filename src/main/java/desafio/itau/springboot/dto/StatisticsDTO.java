package desafio.itau.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsDTO {
    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    public StatisticsDTO(DoubleSummaryStatistics statistics) {
        if (statistics.getCount() == 0) {
            this.sum = 0;
            this.avg = 0;
            this.max = 0;
            this.min = 0;
            this.count = 0;
            return;
        }

        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.max = statistics.getMax();
        this.min = statistics.getMin();
        this.count = statistics.getCount();
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public long getCount() {
        return count;
    }
}
