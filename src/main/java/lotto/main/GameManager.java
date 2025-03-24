package lotto.main;

import lotto.control.Sorter;
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
    private final LottoGenerator lottoGenerator;
    private final ResultCaculator resultCaculator;
    private final Sorter sorter;

    public GameManager() {
        Scanner scanner=new Scanner(System.in);
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
        this.lottoGenerator = new LottoGenerator();
        this.resultCaculator = new ResultCaculator();
        this.sorter = new Sorter();
    }

    public void startGame(){
        //금액 입력받기 - 검증
        int amount = this.inputView.readAmount();

        //금액만큼 로또 생성하기
        List<LottoTicket> tickets = this.lottoGenerator.generate(amount);

        //정렬
        List<LottoTicket> sortedresult = this.sorter.sort(tickets);

        //출력
        this.outputView.printLottoTickets(tickets,amount);

        //로또번호 입력 받기-검증
        List<Integer> winningnumbers = this.inputView.readWinningNumbers();
        Integer bonusnumber = this.inputView.readBonusNumber();

        //결과와 로또 연산 수행하기
        LottoResult result = this.resultCaculator.caculate();

        //결과 출력하기
        this.outputView.printResult(result, amount);
    }

}