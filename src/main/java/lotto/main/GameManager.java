package lotto.main;

import lotto.control.ResultCalculator;
import lotto.view.InputView;
import lotto.control.LottoResult;
import lotto.view.OutputView;
import lotto.control.LottoGenerator;
import lotto.model.LottoTicket;
import java.util.List;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        try{
            int price = getAmount();
            int count = price / LOTTO_PRICE;
            List<LottoTicket> tickets = generateLottos(count);
            printLottos(tickets, count);
            processLotto(tickets, price);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    private int getAmount(){
        return this.inputView.readAmount();
    }

    private List<LottoTicket> generateLottos(int amount){
        return LottoGenerator.generate(amount);
    }

    private void printLottos(List<LottoTicket> tickets, int amount){
        this.outputView.printLottoTickets(tickets,amount);
    }

    private void processLotto(List<LottoTicket> tickets, int amount) {
        List<Integer> winningnumbers = this.inputView.readWinningNumbers();
        int bonusnumber = this.inputView.readBonusNumber(winningnumbers);
        LottoResult result = ResultCalculator.calculate(tickets,winningnumbers,bonusnumber);
        this.outputView.printResult(result, amount);
    }

}