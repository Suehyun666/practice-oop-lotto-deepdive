package lotto.util;

import lotto.domain.LottoResult;

public interface StatisticsCalculator {
    long calculateTotalPrize(LottoResult result);
    double calculateReturnRate(LottoResult result, int purchaseAmount);
}
