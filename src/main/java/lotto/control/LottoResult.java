package lotto.control;

import lotto.constants.LottoRank;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        initializeRankCounts();
    }

    private void initializeRankCounts() {
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                rankCounts.put(rank, 0);
            }
        }
    }

    public void addRank(LottoRank rank) {
        if (rank == LottoRank.NONE) {
            return;
        }
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateReturnRate(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) calculateTotalPrize() / purchaseAmount * 100;
    }

}