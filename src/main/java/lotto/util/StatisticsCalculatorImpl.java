package lotto.util;

import lotto.domain.constants.LottoRank;
import lotto.domain.LottoResult;

public class StatisticsCalculatorImpl implements StatisticsCalculator {
    @Override
    public long calculateTotalPrize(LottoResult result) {
        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                totalPrize += (long) rank.getPrize() * result.getCount(rank);
            }
        }
        return totalPrize;
    }

    @Override
    public double calculateReturnRate(LottoResult result, int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        long totalPrize = calculateTotalPrize(result);
        return (double) totalPrize / purchaseAmount * 100;
    }
}