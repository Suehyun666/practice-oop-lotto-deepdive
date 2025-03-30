package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoRank;
import lotto.dto.LottosDTO;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.text.DecimalFormat;

public class ConsoleView {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_STATIC_START = "당첨 통계\n---";
    private static final String CORRECT_COUNT = "개 일치";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PRICE_FORMAT = "#,###";
    private static final String WON = "원";
    private static final String PROFIT_FORMAT = "0.0";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    // 당첨 결과 출력 형식
    // 일치 개수 + "개 일치" + (보너스볼 일치 여부) + "(" + 상금 + "원)" + " - " + 당첨 개수 + "개"
    private static final String RANK_RESULT_FORMAT = "%d%s%s(%s) - %d개";

    public String readAmount() {
        System.out.println(INPUT_PRICE);
        return Console.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(INPUT_BONUS);
        return Console.readLine();
    }

    public void printLottoTickets(LottosDTO tickets, int count) {
        System.out.println(count + LOTTO_COUNT_MESSAGE);
        for (Lotto ticket : tickets.getNumbers()) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printResult(LottoResult result) {
        System.out.println(OUTPUT_STATIC_START);

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                printRankResult(result, rank);
            }
        }
    }

    private void printRankResult(LottoResult result, LottoRank rank) {
        String bonusMatchText = rank.isBonusMatch() ? BONUS_MATCH : "";

        String resultText = String.format(
                RANK_RESULT_FORMAT,
                rank.getMatchCount(),
                CORRECT_COUNT,
                bonusMatchText,
                formatMoney(rank.getPrize()),
                result.getCount(rank)
        );

        System.out.println(resultText);
    }

    public void printProfit(double returnRate) {
        System.out.println(String.format(PROFIT_MESSAGE, formatRate(returnRate)));
    }

    private String formatMoney(int prize) {
        DecimalFormat formatter = new DecimalFormat(PRICE_FORMAT);
        return formatter.format(prize) + WON;
    }

    private String formatRate(double rate) {
        DecimalFormat formatter = new DecimalFormat(PROFIT_FORMAT);
        return formatter.format(rate);
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}