package lotto.control;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoGenerator {

    public static List<LottoTicket> generate(int count) {
        List<LottoTicket> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
            lottos.add(new LottoTicket(numbers));
        }
        return lottos;
    }

}
