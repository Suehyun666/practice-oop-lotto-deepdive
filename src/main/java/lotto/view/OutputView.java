package lotto.view;

import lotto.control.LottoResult;
import lotto.constants.LottoRank;
import lotto.control.Sorter;
import lotto.model.LottoTicket;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public void printLottoTickets(List<LottoTicket> tickets, int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<LottoTicket> sortedTickets = Sorter.sort(tickets);
        for (LottoTicket ticket : sortedTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printResult(LottoResult result, int amount) {
        System.out.println("\n당첨 통계\n---");
        printRankCount(result, LottoRank.FIFTH);
        printRankCount(result, LottoRank.FOURTH);
        printRankCount(result, LottoRank.THIRD);
        printRankCount(result, LottoRank.SECOND);
        printRankCount(result, LottoRank.FIRST);

        double returnRate = result.calculateReturnRate(amount);
        System.out.println("총 수익률은 " + formatRate(returnRate) + "%입니다.");
    }

    private void printRankCount(LottoResult result, LottoRank rank) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount()).append("개 일치");

        if (rank == LottoRank.SECOND) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" (").append(formatMoney(rank.getPrize())).append(") - ")
                .append(result.getCount(rank)).append("개");

        System.out.println(sb.toString());
    }

    private String formatMoney(int prize) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(prize) + "원";
    }

    private String formatRate(double rate) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(rate);
    }

}
