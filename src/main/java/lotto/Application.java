package lotto;

import lotto.service.GameManager;
import lotto.util.generate.LottoGenerator;
import lotto.util.generate.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        GameManager gameManager = new GameManager(inputView, outputView, lottoGenerator);

        try {
            gameManager.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
