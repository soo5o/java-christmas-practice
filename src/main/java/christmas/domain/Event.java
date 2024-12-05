package christmas.domain;

public class Event {
    private final String eventName;
    private final int discount;
    public Event(String eventName, int discount){
        this.eventName = eventName;
        this.discount = discount;
    }

    public String getEvent() {
        return eventName;
    }

    public int getDiscount() {
        return discount;
    }
}
