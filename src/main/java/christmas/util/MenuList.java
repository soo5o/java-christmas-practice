package christmas.util;

public enum MenuList {
    MENU1("양송이수프", 6000, "애피타이저"),
    MENU2("타파스", 5500, "애피타이저"),
    MENU3("시저샐러드", 8000, "애피타이저"),
    MENU4("티본스테이크", 55000, "메인"),
    MENU5("바비큐립", 54000, "메인"),
    MENU6("해산물파스타", 35000, "메인"),
    MENU7("크리스마스파스타", 25000, "메인"),
    MENU8("초코케이크", 15000, "디저트"),
    MENU9("아이스크림", 5000, "디저트"),
    MENU10("제로콜라", 3000, "음료"),
    MENU11("레드와인", 60000, "음료"),
    MENU12("샴페인", 25000, "음료");
    private final String name;
    private final int price;
    private final String type;
    MenuList(String name, int price, String type){
        this.name = name;
        this.price= price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public static MenuList getMenuByName(String name){
        for(MenuList menu : values()){
            if(menu.getName().equals(name)){
                return menu;
            }
        }
        return null;
    }
    
}
