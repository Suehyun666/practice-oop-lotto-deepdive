package lotto;

import lotto.controller.LottoGameController;
import lotto.service.*;
import lotto.view.ConsoleView;
import lotto.view.View;


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

        View view = new ConsoleView();

        LottoGameController controller = new LottoGameController(
                view,
                gameFacade);

        controller.start();
    }
}
