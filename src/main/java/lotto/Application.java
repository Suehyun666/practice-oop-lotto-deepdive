package lotto;

import lotto.service.GameManager;
import lotto.util.generate.LottoGenerator;
import lotto.util.generate.RandomLottoGenerator;
import lotto.view.ConsoleView;

import static lotto.constants.ErrorConstants.ERROR;

public class Application {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        GameManager gameManager = new GameManager(view, lottoGenerator);
        try {
            gameManager.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
        }
    }
}
