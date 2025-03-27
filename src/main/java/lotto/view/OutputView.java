package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public interface OutputView {
    void printLottoTickets(List<Lotto> tickets, int count);
    void printResult(LottoResult result);
    void printProfit(double returnRate);
}