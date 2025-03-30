
package lotto.service;

import lotto.util.ValidationUtil;
import lotto.model.WinningNumbers;
import java.util.List;

public class WinningNumbersService {

    public WinningNumbers createWinningNumbers(String winningNumbersInput, String bonusNumberInput) {
        List<Integer> numbers = ValidationUtil.parseNumbersList(winningNumbersInput);
        ValidationUtil.validateLottoNumbers(numbers);

        int bonusNumber = ValidationUtil.parseToInt(bonusNumberInput);
        ValidationUtil.validateBonusNumber(bonusNumber, numbers);

        return new WinningNumbers(numbers, bonusNumber);
    }
}