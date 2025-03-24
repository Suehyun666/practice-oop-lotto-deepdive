package lotto.control;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    private Sorter(){
        throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
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
