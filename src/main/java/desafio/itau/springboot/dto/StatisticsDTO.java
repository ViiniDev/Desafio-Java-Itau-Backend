public class StaticsDTO {
    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    public StaticsDTO(DoubleSummaryStatistics statistics) {
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.max = statistics.getMax();
        this.min = statistics.getMin();
        this.count = statistics.getCount();
    }

    public double getSum() {
        return sum;
    } public double getAvg() {
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