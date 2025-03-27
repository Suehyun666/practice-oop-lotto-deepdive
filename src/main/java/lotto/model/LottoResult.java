package lotto.model;

import lotto.constants.LottoRank;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        initializeRankCounts();
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

    private void initializeRankCounts() {
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                rankCounts.put(rank, 0);
            }
        }
    }

}