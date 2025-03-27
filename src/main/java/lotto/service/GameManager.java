package lotto.service;

import lotto.util.LottoStatisticsCalculator;
import lotto.util.ResultCalculator;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.model.LottoResult;
import lotto.view.OutputView;
import lotto.util.generate.LottoGenerator;

import java.util.List;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public GameManager(InputView inputView, OutputView outputView,LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void startGame() {
        int price = inputView.readAmount();
        int count = price / LOTTO_PRICE;

        List<Lotto> tickets = lottoGenerator.generate(count);
        outputView.printLottoTickets(tickets, count);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        LottoResult result = ResultCalculator.calculate(tickets, winningNumbers, bonusNumber);
        outputView.printResult(result);

        double returnRate = LottoStatisticsCalculator.calculateReturnRate(result, price);
        outputView.printProfit(returnRate);
    }

}