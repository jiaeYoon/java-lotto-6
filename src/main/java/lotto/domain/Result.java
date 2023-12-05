package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private final Map<Prize, Integer> result;

    public Result() {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
        this.result = result;
    }

    public Result calculateResult(Winning winning, List<Lotto> lottos) {
        Result result = new Result();
        for (Lotto lotto : lottos) {
            Prize prize = winning.compareTo(lotto);
            result.add(prize);
        }
        return result;
    }

    public void add(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    public int getWinningNumber(Prize prize) {
        return result.get(prize);
    }

    public String calculateProfitRatio(int amount) {
        int profit = 0;
        for (Prize prize : result.keySet()) {
            profit += result.get(prize) * Prize.getWinningValue(prize);
        }
        double profitRatio = (double) profit / amount * 100;
        return String.format("%.1f", profitRatio);
    }
}
