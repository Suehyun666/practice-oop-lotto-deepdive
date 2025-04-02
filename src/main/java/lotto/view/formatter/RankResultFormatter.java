package lotto.view.formatter;

import lotto.constants.LottoRank;

public class RankResultFormatter implements Formatter {
    private final Formatter moneyFormatter;

    public RankResultFormatter(Formatter moneyFormatter) {
        this.moneyFormatter = moneyFormatter;
    }

    @Override
    public String format(Object value) {
        if (!(value instanceof LottoRank)) {
            throw new IllegalArgumentException("로또 등수 객체가 필요합니다.");
        }
        LottoRank rank = (LottoRank) value;
        String bonusMatchText = rank.isBonusMatch() ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s(%s)",
                rank.getMatchCount(),
                bonusMatchText,
                moneyFormatter.format(rank.getPrize()));
    }
}