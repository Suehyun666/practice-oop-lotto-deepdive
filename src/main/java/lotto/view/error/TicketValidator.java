package lotto.view.error;

public class TicketValidator {
    private static final int LOTTO_PRICE = 1000;

    public static int validateTicketAmount(String input) {
        try {
            int price = Integer.parseInt(input);
            if (price < LOTTO_PRICE) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
            }
            if (price % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

}
