package lotto.util;

import lotto.constants.LottoRank;

import java.util.Arrays;

import static lotto.constants.ErrorConstants.INSTANCE_ERROR;

public class RankDeterminer {

    private RankDeterminer() {
        throw new AssertionError(INSTANCE_ERROR);
    }

    public static LottoRank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return LottoRank.SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchCount() == matchCount && !rank.isBonusMatch())
                .findFirst()
                .orElse(LottoRank.NONE);
    }
}