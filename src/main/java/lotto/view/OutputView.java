package lotto.view;

import lotto.model.LottoResult;
import lotto.constants.LottoRank;
import lotto.model.Lotto;
import lotto.util.LottoStatisticsCalculator;
import lotto.util.RankFormatter;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.constants.OutPutConstants.*;

public class OutputView {
    public void printLottoTickets(List<Lotto> tickets, int count) {
        System.out.println(LOTTO_COUNT_MESSAGE1 + count + LOTTO_COUNT_MESSAGE2);
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printResult(LottoResult result) {
        System.out.println(OUTPUT_STATIC_START);
        System.out.println(RankFormatter.formatRankResult(result, LottoRank.FIFTH));
        System.out.println(RankFormatter.formatRankResult(result, LottoRank.FOURTH));
        System.out.println(RankFormatter.formatRankResult(result, LottoRank.THIRD));
        System.out.println(RankFormatter.formatRankResult(result, LottoRank.SECOND));
        System.out.println(RankFormatter.formatRankResult(result, LottoRank.FIRST));
    }

    public void printProfit(double returnRate) {
        System.out.println(PROFIT_MESSAGE_1 + RankFormatter.formatRate(returnRate) + PROFIT_MESSAGE_2);
    }

}
