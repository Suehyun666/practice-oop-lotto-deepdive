package lotto.view.error;

public class TicketValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public int validateTicket(String price) {
        //
        if(Integer.valueOf(price)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
        return price % LOTTO_PRICE;
    }
}
