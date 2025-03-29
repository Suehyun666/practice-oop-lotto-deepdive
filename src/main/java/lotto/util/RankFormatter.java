package lotto.util;

import lotto.constants.LottoRank;
import lotto.model.LottoResult;

import java.text.DecimalFormat;

import static lotto.constants.ErrorConstants.INSTANCE_ERROR;
import static lotto.constants.OutPutConstants.*;

public class RankFormatter {

    private RankFormatter() {
        throw new AssertionError(INSTANCE_ERROR);
    }

    public static String formatRankResult(LottoResult result, LottoRank rank) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getRank()).append(": ");
        sb.append(rank.getMatchCount()).append(CORRECT_COUNT);

        if (rank == LottoRank.SECOND) {

            sb.append(BONUS_COUNT);
        }

        sb.append(Money_FORMAT1)
                .append(formatMoney(rank.getPrize()))
                .append(Money_FORMAT2)
                .append(result.getCount(rank))
                .append(COUNT);

        return sb.toString();
    }

    public static String formatMoney(int prize) {
        DecimalFormat formatter = new DecimalFormat(PRICE_FORMAT);
        return formatter.format(prize) + WON;
    }

    public static String formatRate(double rate) {
        DecimalFormat formatter = new DecimalFormat(PROFIT_FORMAT);
        return formatter.format(rate);
    }
}