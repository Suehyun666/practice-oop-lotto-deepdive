package lotto.control;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<LottoTicket> generate(int amount) {
        int count = amount / LOTTO_PRICE;
        List<LottoTicket> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
            lottos.add(new LottoTicket(numbers));
        }

        return lottos;
    }
}
