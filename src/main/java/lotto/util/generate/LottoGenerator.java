package lotto.util.generate;
import lotto.domain.Lotto;
import java.util.List;
public interface LottoGenerator {
    List<Lotto> generate(int count);
}
