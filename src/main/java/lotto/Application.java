package lotto;

import lotto.service.GameManager;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new LottoGenerator();
        GameManager gameManager = new GameManager(inputView,outputView,lottoGenerator);
        gameManager.startGame();
    }
}
