package lotto.control;

import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {
    // 정적 메서드로 변경
    public static List<LottoTicket> sort(List<LottoTicket> tickets) {
        return tickets.stream()
                .map(ticket -> {
                    List<Integer> sortedNumbers = new ArrayList<>(ticket.getNumbers());
                    Collections.sort(sortedNumbers);
                    return new LottoTicket(sortedNumbers);
                })
                .collect(Collectors.toList());
    }
}
