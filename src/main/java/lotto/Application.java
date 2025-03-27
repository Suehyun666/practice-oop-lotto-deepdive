package lotto;

import lotto.config.AppConfig;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();
        gameController.startGame();
    }
}
