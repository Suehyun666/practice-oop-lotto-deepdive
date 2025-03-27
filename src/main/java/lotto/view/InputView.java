package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.error.LottoValidator;
import lotto.view.error.TicketValidator;
import java.util.List;

import static lotto.constants.InputConstants.*;

public class InputView {

    public InputView() {}

    public int readAmount() {
        System.out.println(INPUT_PRICE);
        String price = Console.readLine();
        return TicketValidator.validate(price);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(INPUT_WINNINGNUMBER);
        String input = Console.readLine();
        return LottoValidator.validate(input);
    }

    public int readBonusNumber(List<Integer> winningnumbers) {
        System.out.println(INPUT_BONUS);
        String input = Console.readLine();
        return LottoValidator.validateBonusNumber(winningnumbers,input);
    }

}
