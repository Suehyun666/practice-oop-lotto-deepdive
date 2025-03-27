package lotto.util.rank;

import lotto.domain.constants.LottoRank;
import java.util.Arrays;

public class RankDeterminerImpl implements RankDeterminer{

    public LottoRank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return LottoRank.SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchCount() == matchCount && !rank.isBonusMatch())
                .findFirst()
                .orElse(LottoRank.NONE);
    }
}