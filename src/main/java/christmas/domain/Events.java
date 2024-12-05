package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Events {
    private int totalBenefit;
    private final String freeEvent;
    private final String badge;
    private final List<Integer> starDay = Arrays.asList(3,10,17,24,25,31);
    private final List<Event> eventList = new ArrayList<>();
    public Events(int day, Order order){
        freeEvent = freeEvent(order.getTotalPrice());
        badge = badgeEvent(totalBenefit);
        if(order.getTotalPrice() < 10000){
            return;
        }
        dDayEvent(day);
        discountEvent(day);
        specialEvent(day);
    }
    private void dDayEvent(int day){
        if (day >= 1 && day <= 25){
            eventList.add(new Event("크리스마스 디데이 할인: ", -((day - 1) * 100 + 1000)));
            totalBenefit = (day - 1) * 100 + 1000;
        }
    }
    private String badgeEvent(int benefit){
        if(benefit >= 20000){
            return "산타";
        }
        if(benefit >= 10000){
            return "트리";
        }
        if(benefit >= 5000){
            return "별";
        }
        return "없음";
    }
    private void discountEvent(int day){
        if(day%7 == 1 || day%7 == 2){ //주말 이벤트 메인 메뉴 1개당 2023원 할인
            eventList.add(new Event("주말 할인: ", -MenuType.getMainCount()*2023));
            totalBenefit += MenuType.getMainCount()*2023;
        }
        //평일 할인 (일~목): 디저트 1개당 2023원 할인
        eventList.add(new Event("평일 할인: ", -MenuType.getDessertCount()*2023));
        totalBenefit += MenuType.getDessertCount()*2023;
    }
    private void specialEvent(int day){
        if(starDay.contains(day)){
            eventList.add(new Event("특별 할인: ", -1000));
            totalBenefit += 1000;
        }
    }
    private String freeEvent(int amount){
        if (amount >= 120000) {
            totalBenefit += 25000;
            eventList.add(new Event("증정 이벤트: ", -25000));
            return "샴페인 1개";
        }
        return "없음";
    }
    public int getTotalBenefit() {
        return totalBenefit;
    }

    public String getBadge() {
        return badge;
    }

    public String getFreeEvent() {
        return freeEvent;
    }

    public List<Event> getEventList() {
        return eventList;
    }
}
