package christmas.domain;

public class MyOrder {
    private final String name;
    private final int quantity;
    public MyOrder(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
}
