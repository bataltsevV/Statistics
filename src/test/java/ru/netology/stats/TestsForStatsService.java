package ru.netology.stats;
import org.intellij.lang.annotations.JdkConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class IntArrayConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context)
            throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new IllegalArgumentException(
                    "The argument should be a string: " + source);
        }
        try {
            return Arrays.stream(((String) source).split(",")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Failed to convert", e);
        }
    }
}

public class TestsForStatsService {

    @ParameterizedTest
    @CsvFileSource(resources = "/InputDataSumSalesForAllMonth.csv", delimiterString = ";")
    //@CsvSource(value = {"180; 8,15,13,15,17,20,19,20,7,14,14,18"}, delimiterString = ";")
    public void TestCalculateSumSalesForAllMonth(int expected,  @ConvertWith(IntArrayConverter.class) int [] companySales){

        StatsService service = new StatsService();
        int actual = (int) service.calculateSumSalesForAllMonth(companySales);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InputDataAverageSumSalesForAllMonth.csv", delimiterString = ";")

    public void TestCalculateAverageSumSalesForAllMonth(double expected,  @ConvertWith(IntArrayConverter.class) int [] companySales){

        StatsService service = new StatsService();
        double actual = service.calculateAverageSumSalesForAllMonth(companySales);


        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InputDataNumberMonthMaxSales.csv", delimiterString = ";")

    public void TestCalculateNumberMonthMaxSales(int expected,  @ConvertWith(IntArrayConverter.class) int [] companySales){

        StatsService service = new StatsService();
        int actual = (int) service.calculateNumberMonthMaxSales(companySales);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InputDataNumberMonthMinSales.csv", delimiterString = ";")

    public void TestCalculateNumberMonthMinSales(int expected,  @ConvertWith(IntArrayConverter.class) int [] companySales){

        StatsService service = new StatsService();
        int actual = (int) service.calculateNumberMonthMinSales(companySales);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InputDataQuantityOfMonthWithSalesBelowAverage.csv", delimiterString = ";")

    public void TestCalculateQuantityOfMonthWithSalesBelowAverage(int expected,  @ConvertWith(IntArrayConverter.class) int [] companySales){

        StatsService service = new StatsService();
        int actual = (int) service.calculateQuantityOfMonthWithSalesBelowAverage(companySales);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InputDataQuantityOfMonthWithSalesAboveAverage.csv", delimiterString = ";")

    public void TestCalculateQuantityOfMonthWithSalesAboveAverage(int expected,  @ConvertWith(IntArrayConverter.class) int [] companySales){

        StatsService service = new StatsService();
        int actual = (int) service.calculateQuantityOfMonthWithSalesAboveAverage(companySales);

        Assertions.assertEquals(expected, actual);
    }

}

