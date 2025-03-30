package lotto.service;

import lotto.util.LottoStatisticsCalculator;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.util.generate.LottoGenerator;
import lotto.view.ConsoleView;

import java.util.List;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class GameManager {

    private final ConsoleView view;
    private final LottoGenerator lottoGenerator;

    public GameManager(ConsoleView view,LottoGenerator lottoGenerator) {
        this.view = view;
        this.lottoGenerator = lottoGenerator;
    }

    public void startGame() {
        int price = view.readAmount();
        int count = price / LOTTO_PRICE;

        List<Lotto> tickets = lottoGenerator.generate(count);
        view.printLottoTickets(tickets, count);

        List<Integer> winningNumbers = view.readWinningNumbers();
        int bonusNumber = view.readBonusNumber(winningNumbers);

        LottoResult result = ResultCalculator.calculate(tickets, winningNumbers, bonusNumber);
        view.printResult(result);

        double returnRate = LottoStatisticsCalculator.calculateReturnRate(result, price);
        view.printProfit(returnRate);
    }

}