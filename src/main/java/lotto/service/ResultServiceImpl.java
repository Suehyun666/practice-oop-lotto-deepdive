package lotto.service;

import lotto.domain.LottoResult;
import lotto.util.StatisticsCalculator;

public class ResultServiceImpl implements ResultService {
    private final StatisticsCalculator statisticsCalculator;

    public ResultServiceImpl(StatisticsCalculator statisticsCalculator) {
        this.statisticsCalculator = statisticsCalculator;
    }

    @Override
    public double calculateReturnRate(LottoResult result, int purchaseAmount) {
        return statisticsCalculator.calculateReturnRate(result, purchaseAmount);
    }
}
