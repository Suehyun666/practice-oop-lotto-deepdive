package lotto.service;

import lotto.constants.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.util.RankDeterminer;

import java.util.List;

public class ResultCalculator {

    public static LottoResult calculate(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(winningNumbers);
        LottoResult result = new LottoResult();

        for (Lotto ticket : tickets) {
            int matchCount = ticket.matchCount(winningLotto);
            boolean bonusMatch = ticket.contains(bonusNumber);
            LottoRank rank = RankDeterminer.determineRank(matchCount, bonusMatch);
            result.addRank(rank);
        }

        return result;
    }
}
