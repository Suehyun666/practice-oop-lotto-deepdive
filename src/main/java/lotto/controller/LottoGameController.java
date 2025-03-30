package lotto.controller;

import lotto.dto.LottosDTO;
import lotto.model.Ticket;
import lotto.model.WinningNumbers;
import lotto.service.LottoGameFacade;
import lotto.service.LottoGameFacade.GameResult;
import lotto.view.ConsoleView;

public class LottoGameController {
    private final ConsoleView view;
    private final LottoGameFacade gameFacade;

    public LottoGameController(ConsoleView view, LottoGameFacade gameFacade) {
        this.view = view;
        this.gameFacade = gameFacade;
    }

    public void start() {
        try {
            String purchaseAmount = view.readAmount();
            LottosDTO lottos = gameFacade.purchaseAndGenerateLottos(purchaseAmount);
            Ticket ticket = new Ticket(purchaseAmount); // 로또 개수 표시용
            view.printLottoTickets(lottos, ticket.getAmount());

            String winningNumbersInput = view.readWinningNumbers();
            String bonusNumberInput = view.readBonusNumber();

            WinningNumbers winningNumbers = gameFacade.createWinningNumbers(winningNumbersInput, bonusNumberInput);

            GameResult result = gameFacade.calculateGameResult(lottos, winningNumbers, ticket.getPrice());

            view.printResult(result.getLottoResult());
            view.printProfit(result.getReturnRate());

        } catch (Exception e) {
            view.printError(e.getMessage());
        }
    }
}