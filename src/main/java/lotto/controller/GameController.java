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
        try {
            processGame();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            startGame(); // 재시도
        } catch (Exception e) {
            outputView.printError("예상치 못한 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 테스트 가능한 핵심 로직 - 예외를 던짐
    public void processGame() {
        // 1. 로또 구매
        int price = inputView.readAmount();
        int count = price / LOTTO_PRICE;
        List<Lotto> tickets = lottoService.generateLottos(count);
        outputView.printLottoTickets(tickets, count);

        // 2. 당첨 번호 입력
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        // 3. 결과 계산 및 출력
        LottoResult result = lottoService.calculateResult(tickets, winningNumbers, bonusNumber);
        double returnRate = resultService.calculateReturnRate(result, price);

        outputView.printResult(result);
        outputView.printProfit(returnRate);
    }
}
