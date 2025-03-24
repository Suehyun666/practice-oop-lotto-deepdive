package lotto.view.error;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String COMMA = ",";
    //error 처리 세가지 -
    public List<Integer> validate(String input) {
        List<Integer> numbers =validateNumber(input);
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        return numbers;
    }

    //error 처리 두가지 - 숫자일 때, 숫자 넘어갈 때, 형식이 이상할 때
    public int validateBonusNumber(String input) {
        try{
            return Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> validateNumber(String input){
        try{
            List<Integer> numbers = Arrays.stream(input.split(COMMA)).map(Integer::valueOf).collect(Collectors.toList());
            return numbers;
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }
}
