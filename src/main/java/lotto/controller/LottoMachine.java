package lotto.controller;

import lotto.util.Util;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Winning;
import lotto.validate.InputValidate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public void on() {
        int amount = setAmount();
        List<Lotto> lottos = issueLotto(amount);
        OutputView.printLottos(lottos);

        Winning winning = Winning.setWinningCondition();
        Result winningResult = getWinningResult(lottos, winning);
        OutputView.printWinningResult(winningResult, amount);
    }

    private Result getWinningResult(List<Lotto> lottos, Winning winning) {
        Result result = new Result();
        return result.calculateResult(winning, lottos);
    }

    private List<Lotto> issueLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount / LottoConfig.LOTTO_PRICE.getValue(); i++) {
            lottos.add(Lotto.issue());
        }
        return lottos;
    }

    private int setAmount() {
        String input;
        while (true) {
            try {
                input = InputView.readAmount();
                InputValidate.amountValidate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Util.toInt(input);
    }
}
