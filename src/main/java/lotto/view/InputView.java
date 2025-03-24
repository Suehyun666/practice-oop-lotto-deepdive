package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.error.LottoValidator;
import lotto.view.error.TicketValidator;
import java.util.List;

public class InputView {

    public InputView() {}

    public int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        return TicketValidator.validate(price);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return LottoValidator.validate(input);
    }

    public int readBonusNumber(List<Integer> winningnumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return LottoValidator.validateBonusNumber(winningnumbers,input);
    }

}
