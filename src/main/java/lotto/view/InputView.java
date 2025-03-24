package lotto.view;

import lotto.view.error.LottoValidator;
import lotto.view.error.TicketValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String COMMA = ",";
    private Scanner scanner;
    private TicketValidator ticketValidator;
    private LottoValidator lottoValidator;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        this.ticketValidator = new TicketValidator();
        this.lottoValidator = new LottoValidator();
    }

    public int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = scanner.nextLine();
        return ticketValidator.validateTicket(price);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return lottoValidator.validate(input);
    }

    public int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return lottoValidator.validateBonusNumber(input);
    }

}
