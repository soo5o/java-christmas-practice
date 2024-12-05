package christmas.domain;

public class MenuType {
    private static int appetizerCount;
    private static int mainCount;
    private static int dessertCount;
    private static int juiceCount;

    public void setAppetizerCount(int quantity) {
        appetizerCount += quantity;
    }

    public void setDessertCount(int quantity) {
        dessertCount += quantity;
    }

    public void setJuiceCount(int quantity) {
        juiceCount += quantity;
    }

    public void setMainCount(int quantity) {
        mainCount += quantity;
    }
    public void orderOnlyJuice(){
        if(appetizerCount == 0 && mainCount == 0 && dessertCount == 0 && juiceCount > 0){
            throw new IllegalArgumentException("음료만 주문 시, 주문할 수 없습니다.");
        }
    }

    public static int getDessertCount() {
        return dessertCount;
    }

    public static int getMainCount() {
        return mainCount;
    }
}
