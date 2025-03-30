package lotto.dto;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottosDTO {
    private final List<Lotto> numbers;

    public LottosDTO(List<Lotto> numbers) {
        this.numbers = Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    public List<Lotto> getNumbers() {
        return numbers;
    }
}