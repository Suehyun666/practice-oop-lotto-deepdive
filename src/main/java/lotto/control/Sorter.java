package lotto.control;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ErrorConstants.INSTANCE_ERROR;

public class Sorter {

    private Sorter(){
        throw new AssertionError(INSTANCE_ERROR);
    }

    public static List<Lotto> sort(List<Lotto> tickets) {
        return tickets.stream()
                .map(ticket -> {
                    List<Integer> sortedNumbers = new ArrayList<>(ticket.getNumbers());
                    Collections.sort(sortedNumbers);
                    return new Lotto(sortedNumbers);
                })
                .collect(Collectors.toList());
    }
}
