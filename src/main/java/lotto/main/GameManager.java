package lotto.main;

import lotto.view.InputView;
import lotto.control.LottoResult;
import lotto.view.OutputView;
import lotto.control.LottoGenerator;
import lotto.control.ResultCaculator;
import lotto.model.LottoTicket;

import java.util.List;
import java.util.Scanner;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;

    public GameManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame(){
        //금액 입력
        int amount = this.inputView.readAmount();

        //로또 생성
        List<LottoTicket> tickets = LottoGenerator.generate(amount);
        this.outputView.printLottoTickets(tickets,amount);

        //당첨 번호 입력
        List<Integer> winningnumbers = this.inputView.readWinningNumbers();
        Integer bonusnumber = this.inputView.readBonusNumber();

        //결과 연산
        LottoResult result = ResultCaculator.calculate(tickets,winningnumbers,bonusnumber);
        this.outputView.printResult(result, amount);
    }

}