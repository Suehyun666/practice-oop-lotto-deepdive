package lotto.util.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.util.validate.LottoValidator;
import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        System.out.println(count + "장의 수동 로또 번호를 입력하세요.");

        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + "번째 수동 번호 입력 (예: 1,2,3,4,5,6): ");
            String input = Console.readLine();

            try {
                List<Integer> numbers = LottoValidator.validate(input);
                lottoTickets.add(new Lotto(numbers));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
        return lottoTickets;
    }
}
