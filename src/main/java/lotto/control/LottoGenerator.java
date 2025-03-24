package lotto.control;

import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public LottoGenerator() {

    }
    public List<LottoTicket> generate(Integer amount) {
        //api 이용해서 로또 생성
        List<LottoTicket> lottos = new ArrayList<LottoTicket>();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        lottos.add(new LottoTicket(numbers));
        return lottos;
    }
}
