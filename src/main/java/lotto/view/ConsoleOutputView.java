package lotto.view;

import lotto.domain.constants.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.text.DecimalFormat;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printLottoTickets(List<Lotto> tickets, int count) {
        System.out.println(LOTTO_COUNT_MESSAGE1 + count + LOTTO_COUNT_MESSAGE2);
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    @Override
    public void printResult(LottoResult result) {
        System.out.println(OUTPUT_STATIC_START);
        printRankCount(result, LottoRank.FIFTH);
        printRankCount(result, LottoRank.FOURTH);
        printRankCount(result, LottoRank.THIRD);
        printRankCount(result, LottoRank.SECOND);
        printRankCount(result, LottoRank.FIRST);
    }

    @Override
    public void printProfit(double returnRate) {
        System.out.println(PROFIT_MESSAGE_1 + formatRate(returnRate) + PROFIT_MESSAGE_2);
    }

    private void printRankCount(LottoResult result, LottoRank rank) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount()).append(CORRECT_COUNT);
        if (rank == LottoRank.SECOND) {
            sb.append(BONUS_COUNT);
        }
        sb.append(Money_FORMAT1).append(formatMoney(rank.getPrize())).append(Money_FORMAT2)
                .append(result.getCount(rank)).append(COUNT);
        System.out.println(sb.toString());
    }

    private String formatMoney(int prize) {
        DecimalFormat formatter = new DecimalFormat(PRICE_FORMAT);
        return formatter.format(prize) + WON;
    }

    private String formatRate(double rate) {
        DecimalFormat formatter = new DecimalFormat(PROFIT_FORMAT);
        return formatter.format(rate);
    }
}
