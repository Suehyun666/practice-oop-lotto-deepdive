package lotto.util;

import lotto.constants.LottoRank;
import lotto.model.LottoResult;

import static lotto.constants.ErrorConstants.INSTANCE_ERROR;

public class LottoStatisticsCalculator {

    private LottoStatisticsCalculator() {
        throw new AssertionError(INSTANCE_ERROR);
    }

    public static long calculateTotalPrize(LottoResult result) {
        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                totalPrize += (long) rank.getPrize() * result.getCount(rank);
            }
        }
        return totalPrize;
    }

    public static double calculateReturnRate(LottoResult result, int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        long totalPrize = calculateTotalPrize(result);
        return (double) totalPrize / purchaseAmount * 100;
    }
}
