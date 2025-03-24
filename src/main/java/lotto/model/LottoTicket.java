package lotto.model;

import java.util.List;

public class LottoTicket {
    private final Lotto lotto;

    public LottoTicket(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int matchCount(Lotto other) {
        return lotto.matchCount(other);
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

}