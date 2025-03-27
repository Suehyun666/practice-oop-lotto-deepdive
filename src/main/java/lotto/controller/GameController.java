package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.domain.constants.ErrorConstants.EXCLUSIVE_ERROR;
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
        try {
            processGame();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            startGame();
        } catch (Exception e) {
            outputView.printError(EXCLUSIVE_ERROR + e.getMessage());
        }
    }

    public void processGame() {
        int price = inputView.readAmount();
        int count = price / LOTTO_PRICE;
        List<Lotto> tickets = lottoService.generateLottos(count);
        outputView.printLottoTickets(tickets, count);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        LottoResult result = lottoService.calculateResult(tickets, winningNumbers, bonusNumber);
        double returnRate = resultService.calculateReturnRate(result, price);

        outputView.printResult(result);
        outputView.printProfit(returnRate);
    }
}
