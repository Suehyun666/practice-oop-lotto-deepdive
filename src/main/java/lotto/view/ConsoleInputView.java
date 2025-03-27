package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.LottoValidator;
import lotto.validate.TicketValidator;

import java.util.List;

public class ConsoleInputView implements InputView {
    @Override
    public int readAmount() {
        System.out.println(INPUT_PRICE);
        String price = Console.readLine();
        return TicketValidator.validate(price);
    }

    @Override
    public List<Integer> readWinningNumbers() {
        System.out.println(INPUT_WINNINGNUMBER);
        String input = Console.readLine();
        return LottoValidator.validate(input);
    }

    @Override
    public int readBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS);
        String input = Console.readLine();
        return LottoValidator.validateBonusNumber(winningNumbers, input);
    }
}