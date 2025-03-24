package lotto.view.error;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.*;

public class LottoValidator {

    private LottoValidator() {
        throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
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
        int number = parseToInt(input, "[ERROR] 보너스 번호는 숫자여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumberDuplicate(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복되면 안됩니다.");
        }
    }

    private static List<Integer> validateNumber(String input) {
        try{
            List<Integer> numbers = Arrays.stream(input.split(COMMA)).map(Integer::valueOf).collect(Collectors.toList());
            return numbers;
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

}
