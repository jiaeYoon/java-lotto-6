package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Result;

import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningResult(Result winningResult, int amount) {
        printWinningDetail(winningResult);
        printProfitRatio(winningResult, amount);
    }

    private static void printProfitRatio(Result winningResult, int amount) {
        System.out.printf("총 수익률은 %s%%입니다.", winningResult.calculateProfitRatio(amount));
    }

    private static void printWinningDetail(Result winningResult) {
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                continue;
            }
            int winningNumber = winningResult.getWinningNumber(prize);
            System.out.println(Prize.getWinningPrizeState(prize, winningNumber));
        }
    }
}
