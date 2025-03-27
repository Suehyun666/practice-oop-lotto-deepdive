package lotto.config;

import lotto.controller.GameController;
import lotto.service.*;
import lotto.util.StatisticsCalculator;
import lotto.util.StatisticsCalculatorImpl;
import lotto.util.rank.RankDeterminer;
import lotto.util.rank.RankDeterminerImpl;
import lotto.util.generate.LottoGenerator;
import lotto.util.generate.RandomLottoGenerator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new ConsoleInputView();
    }

    public OutputView outputView() {
        return new ConsoleOutputView();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoGenerator(), rankDeterminer());
    }

    public ResultService resultService() {
        return new ResultServiceImpl(statisticsCalculator());
    }

    public LottoGenerator lottoGenerator() {
        return new RandomLottoGenerator();
    }

    public RankDeterminer rankDeterminer() {
        return new RankDeterminerImpl();
    }

    public StatisticsCalculator statisticsCalculator() {
        return new StatisticsCalculatorImpl();
    }

    public GameController gameController() {
        return new GameController(
                inputView(),
                outputView(),
                lottoService(),
                resultService()
        );
    }
}