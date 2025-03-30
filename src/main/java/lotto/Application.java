package lotto;

import lotto.controller.LottoGameController;
import lotto.service.*;
import lotto.view.ConsoleView;


public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        LottoService lottoService = new LottoService(lottoGenerator);
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        ResultService resultService = new ResultService();

        LottoGameFacade gameFacade = new LottoGameFacade(
                lottoService,
                winningNumbersService,
                resultService);

        ConsoleView consoleView = new ConsoleView();

        LottoGameController controller = new LottoGameController(
                consoleView,
                gameFacade);

        controller.start();
    }
}
