package lotto.util.validate;

import static lotto.constants.ErrorConstants.*;
import static lotto.constants.LottoConstants.LOTTO_LIMIT_PRICE;
import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class TicketValidator {

    private TicketValidator() {
        throw new AssertionError(INSTANCE_ERROR);
    }

    public static int validate(String input) {
        int price;
        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRICE_TYPE_ERROR);
        }
        if (price > LOTTO_LIMIT_PRICE) {
            throw new IllegalArgumentException(PRICE_MAX_ERROR);
        }
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(PRICE_MIN_ERROR);
        }
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR);
        }
        return price;
    }

}
