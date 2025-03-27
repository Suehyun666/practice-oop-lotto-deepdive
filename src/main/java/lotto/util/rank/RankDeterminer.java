package lotto.util.rank;

import lotto.domain.constants.LottoRank;

public interface RankDeterminer {
    LottoRank determineRank(int matchCount, boolean bonusMatch);
}
