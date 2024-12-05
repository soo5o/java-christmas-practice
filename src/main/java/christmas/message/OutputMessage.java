package christmas.message;

public enum OutputMessage {
    START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    EVENT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    MENU("\n<주문 메뉴>"),
    MENU_LIST("%s %d개\n"),
    BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    FREE_ITEM("\n<증정 메뉴>"),
    BENEFIT("\n<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("\n<총혜택 금액>"),
    AFTER_DISCOUNT("\n<할인 후 예상 결제 금액>"),
    BADGE("\n<12월 이벤트 배지>");
    private final String message;
    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
