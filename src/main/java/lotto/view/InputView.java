package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.error.LottoValidator;
import lotto.view.error.TicketValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String COMMA = ",";

    public InputView() {
    }

    public int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        return TicketValidator.validateTicketAmount(price);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return LottoValidator.validateLottoNumbers(input);
    }

    public int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return LottoValidator.validateBonusNumber(input);
    }

}
