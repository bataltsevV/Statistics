import ru.netology.stats.StatsService;
public class Main {

    public static void main(String[] args) {
        int[] companySales = {
                8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18
        };
        StatsService service = new StatsService();
            System.out.println("Сумма продаж за все месяцы: " + service.calculateSumSalesForAllMonth(companySales));
            System.out.println("Средняя сумма продаж за все время: " + service.calculateAverageSumSalesForAllMonth(companySales));
            System.out.println("Месяц с максимальной суммой продаж: " + service.calculateNumberMonthMaxSales(companySales));
            System.out.println("Месяц с минимальной суммой продаж: " + service.calculateNumberMonthMinSales(companySales));
            System.out.println("Количество месяцев с продажами ниже среднего: " + service.calculateQuantityOfMonthWithSalesBelowAverage(companySales));
            System.out.println("Количество месяцев с продажами выше среднего: " + service.calculateQuantityOfMonthWithSalesAboveAverage(companySales));
    }
}
