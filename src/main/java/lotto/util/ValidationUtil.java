package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoConstants.*;

public class ValidationUtil {

    private ValidationUtil() {
        throw new IllegalStateException(INSTANCE_ERROR.getMessage());
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(WINNING_TYPE_ERROR.getMessage());
        }

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_COUNT_ERROR.getMessage());
        }

        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(WINNING_RANGE_ERROR.getMessage());
        }

        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_DUPLICATE_ERROR.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BONUS_RANGE_ERROR.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR.getMessage());
        }
    }

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_TYPE_ERROR.getMessage());
        }
    }

    public static List<Integer> parseNumbersList(String input) {
        try {
            return Arrays.stream(input.split(COMMA))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (Exception e) {
    throw new IllegalArgumentException(WINNING_TYPE_ERROR.getMessage());
        }
    }
}