package lotto.util.generate;
import lotto.model.Lotto;
import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(int count);
}
