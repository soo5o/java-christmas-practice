package christmas.controller;

import christmas.domain.Events;
import christmas.domain.Order;
import christmas.service.Service;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;
    public Controller(){
        inputView = new InputView();
        outputView = new OutputView();
        service = new Service();
    }
    public void run(){
        int day = getVisitedDay();
        Order order = getMenuAndQuantity();
        getEvent(day, order);
    }
    private int getVisitedDay(){
        while(true){
            try{
                outputView.printStartComment();
                return service.getDay(inputView.inputValue());
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private Order getMenuAndQuantity(){
        while(true){
            try{
                outputView.printGetOrder();
                return service.getOrder(inputView.inputValue());
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private void getEvent(int day, Order order){
        Events event = service.calculateEvent(day, order);
        getMyOrder(day, order);
        outputView.printFreeItem(event.getFreeEvent());
        outputView.printBenefit(event.getEventList());
        getTotalDiscount(event, order);
        outputView.printBadge(event.getBadge());
    }
    private void getMyOrder(int day, Order order){
        outputView.printDecEvent(day);
        outputView.printMenu(order.getOrderMenu());
        outputView.printBeforeDiscount(order.getTotalPrice());
    }
    private void getTotalDiscount(Events event, Order order){
        outputView.printTotalBenefit(-event.getTotalBenefit());
        if(event.getFreeEvent().equals("샴페인 1개")){
            outputView.printAfterDiscount(order.getTotalPrice()-event.getTotalBenefit()+25000);
            return;
        }
        outputView.printAfterDiscount(order.getTotalPrice()-event.getTotalBenefit());
    }
}
