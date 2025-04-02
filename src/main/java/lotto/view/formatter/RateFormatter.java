package lotto.view.formatter;

import java.text.DecimalFormat;

public class RateFormatter implements Formatter {
    private static final String RATE_FORMAT = "0.0";
    private static final String PERCENT = "%";

    @Override
    public String format(Object value) {
        if (!(value instanceof Number)) {
            throw new IllegalArgumentException("수익률은 숫자여야 합니다.");
        }
        double rate = ((Number) value).doubleValue();
        DecimalFormat formatter = new DecimalFormat(RATE_FORMAT);
        return formatter.format(rate) + PERCENT;
    }
}