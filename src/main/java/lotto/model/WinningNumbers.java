package lotto.model;

import lotto.util.ValidationUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        ValidationUtil.validateLottoNumbers(numbers);
        ValidationUtil.validateBonusNumber(bonusNumber, numbers);

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}