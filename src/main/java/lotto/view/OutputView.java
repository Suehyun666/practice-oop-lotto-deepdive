package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public interface OutputView {
    void printLottoTickets(List<Lotto> tickets, int count);
    void printResult(LottoResult result);
    void printProfit(double returnRate);
}