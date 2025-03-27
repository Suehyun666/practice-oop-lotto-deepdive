package lotto.constants;

public class ErrorConstants {
    public static final String INSTANCE_ERROR = "유틸리티 클래스는 인스턴스화할 수 없습니다.";

    public static final String BONUS_TYPE_ERROR = "보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_RANGE_ERROR = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_DUPLICATE_ERROR = "보너스 번호는 중복되면 안됩니다.";

    public static final String WINNING_TYPE_ERROR = "당첨 번호는 쉼표로 구분된 숫자여야 합니다.";
    public static final String WINNING_COUNT_ERROR = "로또 번호는 6개여야 합니다.";
    public static final String WINNING_RANGE_ERROR = "로또 번호는 6개여야 합니다.";
    public static final String WINNING_DUPLICATE_ERROR = "로또 번호는 6개여야 합니다.";

    public static final String PRICE_MAX_ERROR = "로또 구입 금액은 100,000원 이하이어야 합니다.";
    public static final String PRICE_MIN_ERROR = "로또 구입 금액은 1,000원 이상이어야 합니다.";
    public static final String PRICE_UNIT_ERROR = "로또 구입 금액은 1,000원 단위여야 합니다.";
    public static final String PRICE_TYPE_ERROR = "숫자가 너무 크거나 숫자가 아닙니다.";

}
