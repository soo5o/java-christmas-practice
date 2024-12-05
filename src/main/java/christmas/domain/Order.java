package christmas.domain;

import christmas.util.ChristmasConfig;
import christmas.util.MenuList;
import java.util.ArrayList;
import java.util.List;
import static christmas.message.ErrorMessage.INVALID_ORDER;

public class Order {
    List<MyOrder> orderMenu;
    private int totalPrice = 0;
    private int totalQuantity = 0;
    public Order(List<String> orders){
        List<MyOrder> tempOrderMenu = new ArrayList<>();
        MenuType mt = new MenuType();
        for(String order : orders){
            String name = order.split(ChristmasConfig.DELIMITER_DASH)[0];
            String quantity = order.split(ChristmasConfig.DELIMITER_DASH)[1];
            MenuList ml = validateMenu(name);
            int q = validateQuantity(quantity);
            getMenuType(q, ml.getType(), mt);
            updateTotalPrice(ml.getPrice(), q);
            tempOrderMenu.add(new MyOrder(name, q));
        }
        checkOrder(mt);
        this.orderMenu = tempOrderMenu;
    }
    private MenuList validateMenu(String name){
        MenuList s = MenuList.getMenuByName(name);
        if(s == null){
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage());
        }
        return s;
    }
    private int validateQuantity(String quantity){
        try{
            int q = Integer.parseInt(quantity);
            if(q < 1){
                throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage());
            }
            totalQuantity += q;
            return q;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage());
        }
    }
    private void checkOrder(MenuType mt){
        if(totalQuantity > 20){
            throw new IllegalArgumentException("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n" +
                    "(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)");
        }
        mt.orderOnlyJuice();
    }
    private void getMenuType(int quantity, String type, MenuType mt){
        if(type.equals("애피타이저")){
            mt.setAppetizerCount(quantity);
            return;
        }
        if (type.equals("메인")) {
            mt.setMainCount(quantity);
            return;
        }
        if (type.equals("디저트")) {
            mt.setDessertCount(quantity);
            return;
        }
        mt.setJuiceCount(quantity);
    }
    private void updateTotalPrice(int price, int quantity){
        totalPrice += price*quantity;
    }
    public List<MyOrder> getOrderMenu() {
        return orderMenu;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
