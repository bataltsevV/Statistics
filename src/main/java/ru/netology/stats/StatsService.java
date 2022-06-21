package ru.netology.stats;
import static ru.netology.stats.DoubleRound.round;

public class StatsService {
    public long calculateSumSalesForAllMonth(int[] sales) {
        long sumSales = 0;

        for (long sale : sales) {
            sumSales = sumSales + sale;
        }

        return sumSales;
    }

    public double calculateAverageSumSalesForAllMonth(int[] sales) {
        double averageSumSales = (double) calculateSumSalesForAllMonth(sales) / sales.length;

        return round(averageSumSales, 3);
    }

    public int calculateNumberMonthMaxSales(int[] sales) {
        int maxMonth = 0;
        int month = 0;

        for (long sale : sales) {
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month++;
        }

        return maxMonth + 1;
    }

    public int calculateNumberMonthMinSales(int[] sales) {
        int minMonth = 0;
        int month = 0;

        for (long sale : sales) {
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month++;
        }

        return minMonth + 1;
    }

    public int calculateQuantityOfMonthWithSalesBelowAverage(int[] sales) {
        int monthBelowAverage = 0;
        double average = calculateAverageSumSalesForAllMonth(sales);

        for (long sale : sales) {
            if (sale < average) {
                monthBelowAverage++;
            }
        }

        return monthBelowAverage;
    }

    public int calculateQuantityOfMonthWithSalesAboveAverage(int[] sales){
        int     monthAboveAverage = 0;
        double  average = calculateAverageSumSalesForAllMonth(sales);

        for (long sale : sales) {
            if (sale > average){
                monthAboveAverage++;
            }
        }

        return monthAboveAverage;
    }
}
