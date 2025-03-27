package lotto.view;

import java.util.List;

public interface InputView {
    int readAmount();
    List<Integer> readWinningNumbers();
    int readBonusNumber(List<Integer> winningNumbers);
}