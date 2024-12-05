package christmas.service;

import christmas.domain.Events;
import christmas.domain.Order;
import christmas.util.ChristmasConfig;
import java.util.Arrays;
import java.util.List;
import static christmas.message.ErrorMessage.INVALID_DAY;

public class Service {
    public int getDay(String input){
        try{
            int day = Integer.parseInt(input);
            if (day < 1 || day > 31){
                throw new IllegalArgumentException(INVALID_DAY.getErrorMessage());
            }
            return day;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_DAY.getErrorMessage());
        }
    }
    public Order getOrder(String input){
        List<String> orders = Arrays.stream(input.split(ChristmasConfig.DELIMITER_COMMA)).map(String::trim).toList();
        return new Order(orders);
    }
    public Events calculateEvent(int day, Order order){
        return new Events(day, order);
    }
}
