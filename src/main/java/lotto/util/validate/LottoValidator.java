package lotto.util.validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ErrorConstants.*;
import static lotto.constants.LottoConstants.*;

public class LottoValidator {

    private LottoValidator() {
        throw new AssertionError(INSTANCE_ERROR);
    }

    public static List<Integer> validate(String input) {
        List<Integer> numbers = validateNumber(input);
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        return numbers;
    }

    public static List<Integer> validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        return numbers;
    }

    public static int validateBonusNumber(List<Integer> winningNumbers, String input) {
        int number = parseToInt(input, BONUS_TYPE_ERROR);
        validateBonusNumberRange(number);
        validateBonusNumberDuplicate(winningNumbers, number);
        return number;
    }

    private static int parseToInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateBonusNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BONUS_RANGE_ERROR);
        }
    }

    private static void validateBonusNumberDuplicate(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR);
        }
    }

    private static List<Integer> validateNumber(String input) {
        try{
            List<Integer> numbers = Arrays.stream(input.split(COMMA)).map(Integer::valueOf).collect(Collectors.toList());
            return numbers;
        }catch (Exception e){
            throw new IllegalArgumentException(WINNING_TYPE_ERROR);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_COUNT_ERROR);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(WINNING_RANGE_ERROR);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_DUPLICATE_ERROR);
        }
    }

}
