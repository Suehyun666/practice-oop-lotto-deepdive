package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final ResultService resultService;

    public GameController(
            InputView inputView,
            OutputView outputView,
            LottoService lottoService,
            ResultService resultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.resultService = resultService;
    }

    public void startGame() {
        // 1. 로또 구매
        int price = inputView.readAmount();
        int count = price / LOTTO_PRICE;
        List<Lotto> tickets = lottoService.generateLottos(count);
        outputView.printLottoTickets(tickets, count);

        // 2. 당첨 번호 입력
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        // 3. 결과 계산
        LottoResult result = lottoService.calculateResult(tickets, winningNumbers, bonusNumber);
        double returnRate = resultService.calculateReturnRate(result, price);

        // 4. 결과 출력
        outputView.printResult(result);
        outputView.printProfit(returnRate);
    }
}
