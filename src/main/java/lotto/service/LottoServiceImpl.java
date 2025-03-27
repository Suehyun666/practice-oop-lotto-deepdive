package lotto.service;


import lotto.domain.constants.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.util.rank.RankDeterminer;
import lotto.util.generate.LottoGenerator;

import java.util.List;

public class LottoServiceImpl implements LottoService {
    private final LottoGenerator lottoGenerator;
    private final RankDeterminer rankDeterminer;

    public LottoServiceImpl(LottoGenerator lottoGenerator, RankDeterminer rankDeterminer) {
        this.lottoGenerator = lottoGenerator;
        this.rankDeterminer = rankDeterminer;
    }

    @Override
    public List<Lotto> generateLottos(int count) {
        return lottoGenerator.generate(count);
    }

    @Override
    public LottoResult calculateResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(winningNumbers);
        LottoResult result = new LottoResult();

        for (Lotto ticket : tickets) {
            int matchCount = ticket.matchCount(winningLotto);
            boolean bonusMatch = ticket.contains(bonusNumber);
            LottoRank rank = rankDeterminer.determineRank(matchCount, bonusMatch);
            result.addRank(rank);
        }

        return result;
    }
}
