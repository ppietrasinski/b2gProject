package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class TestHelpers {

    private Logger logger = LogManager.getRootLogger();

    public Double getHighestPriceAsDoubleFromThePricesList(List<String> listOfPrices) {
        List<String> editedPricesListAsString = editStringsList(listOfPrices);
        List<Double> pricesListAsDoubles = convertStringListToDoubleList(editedPricesListAsString);
        return findHighestDoubleInDoubleList(pricesListAsDoubles);
    }

    public int getAmountOfElementsFromTheList(List<String> listOfPrices) {
        return listOfPrices.size();
    }

    public List<String> editStringsList(List<String> listOfProductsPrices) {
        logger.info("replacing ',' in string to '.'");
        logger.info("delete last two characters of string");
        return listOfProductsPrices.stream()
                .map(i -> i.toString().replaceAll("\\s+", "").replace(",","."))
                .map(i -> i.substring(0, i.length() - 2))
                .collect(Collectors.toList());
    }

    public List<Double> convertStringListToDoubleList(List <String> stringList) {
        logger.info("changing String list to Double list");
        return stringList.stream()
                .map(Double::valueOf)
                .collect(Collectors.toList());
    }

    public Double findHighestDoubleInDoubleList(List<Double> doubleList) {
        logger.info("getting highest double from double list");
        return doubleList.stream()
                .max(Double::compareTo)
                .get();
    }

    public Double addPercentValueToDouble(int percentValue, Double doubleNumber) {
        logger.info("adding " + percentValue + "% to " + doubleNumber);
        Double multiplyingValue = 1 + (percentValue * 0.01);
        return Math.round(doubleNumber * multiplyingValue * 100)/100.0d;
    }

}
