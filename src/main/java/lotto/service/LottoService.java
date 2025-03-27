package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public interface LottoService {
    List<Lotto> generateLottos(int count);
    LottoResult calculateResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber);
}
