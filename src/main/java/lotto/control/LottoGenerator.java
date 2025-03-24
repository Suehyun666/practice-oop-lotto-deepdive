package lotto.control;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoGenerator {

    private LottoGenerator() {
        throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
    }

    public static List<Lotto> generate(int count) {
        List<Lotto> lottotickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
            lottotickets.add(new Lotto(numbers));
        }
        return lottotickets;
    }

}
