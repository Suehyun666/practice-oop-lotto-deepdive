package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoRank;
import lotto.dto.LottosDTO;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.text.DecimalFormat;

public class ConsoleView implements View {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_STATIC_START = "당첨 통계\n---";
    private static final String RANK_FORMAT = "%s - %d개";
    private static final String PROFIT_FORMAT = "0.0";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    @Override
    public String readAmount() {
        System.out.println(INPUT_PRICE);
        return Console.readLine();
    }
    @Override
    public String readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }
    @Override
    public String readBonusNumber() {
        System.out.println(INPUT_BONUS);
        return Console.readLine();
    }
    @Override
    public void printLottoTickets(LottosDTO tickets, int count) {
        System.out.println(count + LOTTO_COUNT_MESSAGE);
        for (Lotto ticket : tickets.getLottos()) {
            System.out.println(ticket.getNumbers());
        }
    }
    @Override
    public void printResult(LottoResult result) {
        System.out.println(OUTPUT_STATIC_START);

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                printRankResult(result, rank);
            }
        }
    }
    private void printRankResult(LottoResult result, LottoRank rank) {
        String resultText = String.format(
                RANK_FORMAT,
                rank.toString(),
                result.getCount(rank)
        );

        System.out.println(resultText);
    }
    @Override
    public void printProfit(double returnRate) {
        System.out.println(String.format(PROFIT_MESSAGE, formatRate(returnRate)));
    }

    private String formatRate(double rate) {
        DecimalFormat formatter = new DecimalFormat(PROFIT_FORMAT);
        return formatter.format(rate);
    }
    @Override
    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}