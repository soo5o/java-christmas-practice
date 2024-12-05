package christmas.view;

import christmas.domain.Event;
import christmas.domain.MyOrder;
import java.text.DecimalFormat;
import java.util.List;
import static christmas.message.OutputMessage.*;

public class OutputView {
    DecimalFormat formatter = new DecimalFormat("#,###");
    public void printStartComment(){
        System.out.println(START.getMessage());
    }
    public void printGetOrder(){
        System.out.println(ORDER.getMessage());
    }
    public void printDecEvent(int day){
        System.out.printf(EVENT.getMessage(), day);
    }
    public void printMenu(List<MyOrder> orders){
        System.out.println(MENU.getMessage());
        for(MyOrder order : orders){
            System.out.printf(MENU_LIST.getMessage(), order.getName(), order.getQuantity());
        }
    }
    public void printBeforeDiscount(int amount){
        System.out.println();
        System.out.println(BEFORE_DISCOUNT.getMessage());
        System.out.println(formatter.format(amount)+"원");
    }
    public void printFreeItem(String item){
        System.out.println(FREE_ITEM.getMessage());
        System.out.println(item);
    }
    public void printBenefit(List<Event> events){
        System.out.println(BENEFIT.getMessage());
        if(events.size() == 0){
            System.out.println("없음");
            return;
        }
        for(Event event : events){
            System.out.println(event.getEvent()+formatter.format(event.getDiscount())+"원");
        }
    }
    public void printTotalBenefit(int benefit){
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.println(formatter.format(benefit)+"원");
    }
    public void printAfterDiscount(int discount){
        System.out.println(AFTER_DISCOUNT.getMessage());
        System.out.println(formatter.format(discount)+"원");
    }
    public void printBadge(String badge){
        System.out.println(BADGE.getMessage());
        System.out.println(badge);
    }
    public void printErrorMessage(String e){
        System.out.println(e);
    }
}
