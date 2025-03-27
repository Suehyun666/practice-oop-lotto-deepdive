package lotto.service;

import lotto.domain.LottoResult;

public interface ResultService {
    double calculateReturnRate(LottoResult result, int purchaseAmount);
}
