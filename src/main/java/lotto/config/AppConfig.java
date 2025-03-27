package lotto.config;

import lotto.util.RankDeterminer;
import lotto.util.generate.LottoGenerator;
import lotto.util.generate.RandomLottoGenerator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    // 1. 기본 컴포넌트 생성
    public InputView inputView() {
        return new ConsoleInputView();
    }

    public OutputView outputView() {
        return new ConsoleOutputView();
    }

    // 2. 서비스 레이어 생성
    public LottoService lottoService() {
        return new LottoServiceImpl(lottoGenerator(), rankDeterminer());
    }

    public ResultService resultService() {
        return new ResultServiceImpl(statisticsCalculator());
    }

    // 3. 유틸리티 컴포넌트들 (정적 메서드를 인스턴스 메서드로 변환)
    public LottoGenerator lottoGenerator() {
        return new RandomLottoGenerator();
    }

    public RankDeterminer rankDeterminer() {
        return new RankDeterminerImpl();
    }

    public StatisticsCalculator statisticsCalculator() {
        return new StatisticsCalculatorImpl();
    }

    // 4. 컨트롤러/코디네이터 생성
    public GameController gameController() {
        return new GameController(
                inputView(),
                outputView(),
                lottoService(),
                resultService()
        );
    }
}